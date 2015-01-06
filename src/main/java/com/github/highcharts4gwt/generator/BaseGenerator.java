package com.github.highcharts4gwt.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

import com.github.highcharts4gwt.generator.codemodel.ClassWriter;
import com.github.highcharts4gwt.generator.codemodel.OutputType;
import com.github.highcharts4gwt.generator.graph.Option;
import com.github.highcharts4gwt.generator.graph.OptionTree;
import com.github.highcharts4gwt.generator.graph.OptionUtils;
import com.github.highcharts4gwt.generator.graph.OptionsData;
import com.github.highcharts4gwt.generator.highsoft.ConfigurationType;
import com.github.highcharts4gwt.generator.highsoft.Product;
import com.github.highcharts4gwt.generator.jsonparser.OptionParser;
import com.sun.codemodel.JClassAlreadyExistsException;

public abstract class BaseGenerator implements Generator
{

    private final Product product;

    private final static String CHART_OPTIONS_FULLNAME = "chartOptions";

    public BaseGenerator(Product product, ConfigurationType configurationType) throws IOException
    {
        this.product = product;
        properties = loadProperties();
        packageName = getOutputPackagePrefix() + getProductPackageName() + "." + configurationType.getPackageName();
        cleanDirectory(getRootDirectory() + "/" + packageToPath(packageName));
    }

    @Override
    public void generate() throws IOException, JClassAlreadyExistsException
    {
        OptionsData optionsData = readOptions();

        generateClasses(optionsData);
    }

    private OptionsData readOptions() throws IOException
    {
        String optionsAsString = readProductOptionsFile();

        if (optionsAsString == null)
            throw new RuntimeException("Cannot read options from " + product.getProductPackageName());

        OptionsData optionsData = OptionParser.parse(optionsAsString);
        return optionsData;
    }

    public String getProductPackageName()
    {
        return product.getProductPackageName();
    }

    protected final String getOutputPackagePrefix() throws IOException
    {
        return getPropertyValue(GENERATOR_OUTPUT_PACKAGEPREFIX);
    }

    protected String getPropertyValue(String propertyName) throws IOException
    {
        return properties.getProperty(propertyName);
    }

    protected abstract Logger getLogger();

    private String getRootDirectory() throws IOException
    {
        return getPropertyValue(GENERATOR_OUTPUT_ROOTDIR);
    }

    private void generateClasses(OptionsData optionsData) throws JClassAlreadyExistsException, IOException
    {

        List<OptionTree> trees = optionsData.getTrees();
        if (product == Product.Highcharts)
        {
            // we want to build series first so that we can use this class
            // inside events
            trees = OptionUtils.getTreesInOrder(optionsData, "series");
        }

        for (OptionTree tree : trees)
        {
            exploreSubTree(tree.getRoot(), optionsData);
        }

        writeTopClass(optionsData);
    }

    private void exploreSubTree(Option option, OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        if (!option.isParent())
        {
            getLogger().warn("Not a node, cannot explore subtree;" + option);
            return;
        }

        OptionTree tree = options.findTree(option);

        List<Option> children = tree.getChildren(option);
        if (children == null)
            throw new RuntimeException("No children whereas isParent" + ";" + option);

        for (Option child : children)
        {
            exploreChild(child, options);
        }

        writeClasses(option, tree);
    }

    private void exploreChild(Option option, OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        if (option.isParent())
            exploreSubTree(option, options);
        else
            getLogger().trace("Option is a leaf, no need to create class;" + option);
    }

    private void writeTopClass(OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        for (OutputType outputType : OutputType.values())
        {
            ClassWriter builder = outputType.accept(new ClassWritterVisitor(), getRootDirectory());
            if (builder != null)
            {
                Option option = new Option(CHART_OPTIONS_FULLNAME, CHART_OPTIONS_FULLNAME, CHART_OPTIONS_FULLNAME);
                OptionTree topOptionTree = new OptionTree(option);
                List<Option> children = new ArrayList<Option>();
                for (OptionTree tree : options.getTrees())
                {
                    Option root = tree.getRoot();

                    // TODO need to be able to set those options on a global
                    // highcharts wrapper
                    if (root.getFullname().equals("global") || root.getFullname().equals("lang"))
                        continue;

                    children.add(root);
                }
                topOptionTree.addParentChildren(option, children);
                builder.setPackageName(computePackageName(option, outputType)).setOption(option).setTree(topOptionTree);
                builder.write();
            }
        }
    }

    private void writeClasses(Option option, OptionTree tree) throws IOException, JClassAlreadyExistsException
    {
        if (!option.isParent())
            return;

        for (OutputType outputType : OutputType.values())
        {
            ClassWriter builder = outputType.accept(new ClassWritterVisitor(), getRootDirectory());
            writeClass(option, tree, builder, outputType);
        }
    }

    private void writeClass(Option option, OptionTree tree, ClassWriter builder, OutputType outputType) throws IOException, JClassAlreadyExistsException
    {
        if (builder != null)
        {
            builder.setPackageName(computePackageName(option, outputType)).setOption(option);
            builder.setTree(tree);
            builder.write();
        }
    }

    private String computePackageName(Option option, OutputType outputType)
    {
        String pckg = packageName + "." + outputType.getRootPackageName();
        String highchartsPackageName = OptionUtils.getHighchartsPackageName(option);
        if (!highchartsPackageName.equalsIgnoreCase(""))
        {
            pckg += "." + highchartsPackageName;
        }
        return pckg;
    }

    private Properties loadProperties() throws IOException
    {
        Properties out = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream(CONFIGURATION_FILENAME);
        if (inputStream == null)
        {
            throw new FileNotFoundException("property file '" + CONFIGURATION_FILENAME + "' not found in the classpath");
        }

        out.load(inputStream);
        return out;
    }

    private void cleanDirectory(String dirPath) throws IOException
    {
        File directory = new File(dirPath);

        if (directory.isDirectory() && directory.exists())
            FileUtils.cleanDirectory(directory);
    }

    private String packageToPath(String packageName)
    {
        String path = packageName.replace(".", "/");
        return path;
    }

    private static final String CONFIGURATION_FILENAME = "configuration.properties";
    private static final String GENERATOR_OUTPUT_PACKAGEPREFIX = "generator.output.packagePrefix";
    private static final String GENERATOR_OUTPUT_ROOTDIR = "generator.output.rootDir";
    private final Properties properties;
    private final String packageName;
}
