package com.usesoft.highcharts4gwt.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.CheckForNull;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.slf4j.Logger;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;
import com.usesoft.highcharts4gwt.generator.graph.OptionUtils;
import com.usesoft.highcharts4gwt.generator.graph.OptionsData;
import com.usesoft.highcharts4gwt.generator.highsoft.Product;

public abstract class BaseGenerator implements Generator
{

    private final Product product;

    public BaseGenerator(Product product) throws IOException
    {
        this.product = product;
        properties = loadProperties();
        packageName = getOutputPackagePrefix() + getProductPackageName();
        cleanDirectory(getRootDirectory() + "/" + packageToPath(packageName));
    }

    @Override
    public void generate() throws IOException, JClassAlreadyExistsException
    {
        optionsData = createOptions();
        generateClasses(optionsData);
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

    private void generateClasses(OptionsData options) throws JClassAlreadyExistsException, IOException
    {
        for (OptionTree tree : options.getTrees())
        {
            writeSubTree(tree.getRoot(), options);
        }

        writeTopClass(options);
    }

    private void writeSubTree(Option option, OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        if (!option.isParent())
        {
            getLogger().warn("Node but not parent ?!;" + option);
            return;
            // throw new RuntimeException("Not a node;" + option.getFullname());
        }

        writeExtendingOptionFirst(option, options);

        OptionTree tree = options.findTree(option);

        List<Option> children = tree.getChildren(option);
        if (children == null)
            throw new RuntimeException("Children is null for parent option;" + option.getFullname());

        for (Option child : children)
        {
            writeChild(child, options);
        }

        writeClassForAllTypes(tree, option);

        // getLogger().info("Node written;" + option);
    }

    private void writeExtendingOptionFirst(Option option, OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        Option extendedOption = options.findExtendedOption(option, optionsData);
        if (extendedOption != null)
        {
            getLogger().info("Node;" + option + ";extends;" + extendedOption);
            if (extendedOption.isParent())
                writeSubTree(extendedOption, options);
            else
            {
                getLogger().warn("Extended option is a leaf ?!" + extendedOption);
                writeLeaf(extendedOption, options);
            }
        }
    }

    private void writeChild(Option option, OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        if (option.isParent())
            writeSubTree(option, options);
        else
            writeLeaf(option, options);
    }

    private void writeLeaf(Option option, OptionsData options)
    {
        if (option.isParent())
            throw new RuntimeException("Leaf cannot be parent;" + option.getFullname());

        // getLogger().info("Leaf written;" + option);
    }

    private void writeTopClass(OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        for (OutputType outputType : OutputType.values())
        {
            ClassBuilder builder = outputType.accept(new ClassWritterVisitor(), getRootDirectory());
            if (builder != null)
            {
                String fullname = "chartOptions";
                Option option = new Option(fullname, fullname, fullname);
                OptionTree topOptionTree = new OptionTree(option);
                List<Option> children = new ArrayList<Option>();
                for (OptionTree tree : options.getTrees())
                {
                    children.add(tree.getRoot());
                }
                topOptionTree.addParentChildren(option, children);
                builder.setPackageName(computePackageName(option, outputType)).setOption(option, options).setTree(topOptionTree);
                builder.build();
            }
        }
    }

    private void writeClassForAllTypes(OptionTree tree, Option option) throws IOException, JClassAlreadyExistsException
    {
        if (!option.isParent())
            return;

        for (OutputType outputType : OutputType.values())
        {
            ClassBuilder builder = outputType.accept(new ClassWritterVisitor(), getRootDirectory());
            writeClass(tree, option, builder, outputType);
        }
    }

    private void writeClass(OptionTree tree, Option option, ClassBuilder builder, OutputType outputType) throws IOException, JClassAlreadyExistsException
    {
        if (builder != null)
        {
            builder.setPackageName(computePackageName(option, outputType)).setOption(option, optionsData);
            builder.setTree(tree);

            Option extendedOption = optionsData.findExtendedOption(option, optionsData);
            if (extendedOption != null)
                builder.setExtendedOption(extendedOption);
            builder.build();
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

    private OptionsData createOptions() throws IOException
    {
        String optionsAsString = readProductOptionsFile();

        if (optionsAsString == null)
            throw new RuntimeException("Cannot read options from " + product.getProductPackageName());

        JSONArray jsonArray = JsonUtils.extractOptions(optionsAsString);

        return JsonUtils.createOptions(jsonArray);
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
    @CheckForNull
    private OptionsData optionsData;
}
