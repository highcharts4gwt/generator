package com.github.highcharts4gwt.generator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;

import com.github.highcharts4gwt.generator.common.ObjectOrOptionUtils;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.model.highsoft.ConfigurationType;
import com.github.highcharts4gwt.generator.model.highsoft.Product;
import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.OptionClassWritterVisitor;
import com.github.highcharts4gwt.generator.option.OptionTree;
import com.github.highcharts4gwt.generator.option.OptionUtils;
import com.github.highcharts4gwt.generator.option.OptionsData;
import com.github.highcharts4gwt.generator.option.jsonparser.OptionParser;
import com.github.highcharts4gwt.generator.option.klass.OptionClassWriter;
import com.sun.codemodel.JClassAlreadyExistsException;

public abstract class BaseGenerator implements Generator
{
    private static final String CHART_OPTIONS_FULLNAME = "chartOptions";
    private static final String GLOBAL_OPTIONS_FULLNAME = "globalOptions";

    public BaseGenerator(Product product, ConfigurationType configurationType) throws IOException
    {
        this.product = product;
        properties = loadProperties();

        String prePackage = getOutputPackagePrefix() + getProductPackageName() + ".";
        optionPackageName = prePackage + ConfigurationType.Option.getPackageName();
        objectPackageName = prePackage + ConfigurationType.Object.getPackageName();

        String prePath = getRootDirectory() + "/";
        DirectoryUtils.cleanDirectory(prePath + DirectoryUtils.packageToPath(optionPackageName), getLogger());
    }

    @Override
    public void generateClasses() throws IOException, JClassAlreadyExistsException
    {
        String objectsAsString = readProductObjectsFile();
        ObjectsGenerator objectGenerator = new ObjectsGenerator(objectsAsString, product, getRootDirectory(), objectPackageName);

        objectGenerator.cleanObjectDirectory();

        //Need to create object classes first to be used in option callbacks
        objectGenerator.createEmptyObjectClasses();

        generateOptions();

        //Then enrich object with option fields
        objectGenerator.enrichObjectClassesWithFields();
        objectGenerator.writeObjectClassesToDisk();
    }

    private void generateOptions() throws IOException, JClassAlreadyExistsException
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

        writeTopClasses(optionsData);
    }

    // Write deeper classes first with recurrence
    private void exploreSubTree(Option option, OptionsData optionsData) throws IOException, JClassAlreadyExistsException
    {
        if (!option.isParent())
        {
            getLogger().warn("Not a node, cannot explore subtree;" + option);
            return;
        }

        OptionTree tree = optionsData.findTree(option);

        List<Option> children = tree.getChildren(option);
        if (children == null && !option.getFullname().equals("series"))
            throw new RuntimeException("No children whereas isParent" + ";" + option);

        if (children != null) //series case
        {
            for (Option child : children)
            {
                exploreChild(child, optionsData);
            }
        }
        writeOptionClasses(option, tree);
    }

    private void exploreChild(Option option, OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        if (option.isParent())
            exploreSubTree(option, options);
        else
            getLogger().trace("Option is a leaf, no need to create class;" + option);
    }

    private void writeTopClasses(OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        writeChartOptions(options);
        writeGlobalOptions(options);
    }

    private void writeChartOptions(OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        for (OutputType outputType : OutputType.values())
        {
            OptionClassWriter classWriter = outputType.accept(new OptionClassWritterVisitor(), getRootDirectory());
            if (classWriter != null)
            {
                Option chartOptionRoot = new Option(CHART_OPTIONS_FULLNAME, CHART_OPTIONS_FULLNAME, CHART_OPTIONS_FULLNAME).setIsParent(true);
                OptionTree topOptionTree = new OptionTree(chartOptionRoot);
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
                topOptionTree.addParentChildren(chartOptionRoot, children);
                classWriter.setPackageName(ObjectOrOptionUtils.computePackageName(chartOptionRoot, outputType, optionPackageName))
                    .setOption(chartOptionRoot)
                    .setTree(topOptionTree);
                classWriter.write();
            }
        }
    }

    private void writeGlobalOptions(OptionsData options) throws IOException, JClassAlreadyExistsException
    {
        for (OutputType outputType : OutputType.values())
        {
            OptionClassWriter builder = outputType.accept(new OptionClassWritterVisitor(), getRootDirectory());
            if (builder != null)
            {
                Option option = new Option(GLOBAL_OPTIONS_FULLNAME, GLOBAL_OPTIONS_FULLNAME, GLOBAL_OPTIONS_FULLNAME).setIsParent(true);
                OptionTree topOptionTree = new OptionTree(option);
                List<Option> children = new ArrayList<Option>();

                children.add(options.findTreeWithRootFullName("global").getRoot());
                children.add(options.findTreeWithRootFullName("lang").getRoot());

                topOptionTree.addParentChildren(option, children);
                builder.setPackageName(ObjectOrOptionUtils.computePackageName(option, outputType, optionPackageName)).setOption(option).setTree(topOptionTree);
                builder.write();
            }
        }
    }

    private void writeOptionClasses(Option option, OptionTree tree) throws IOException, JClassAlreadyExistsException
    {
        if (!option.isParent())
            return;

        for (OutputType outputType : OutputType.values())
        {
            OptionClassWriter builder = outputType.accept(new OptionClassWritterVisitor(), getRootDirectory());
            writeOptionClass(option, tree, builder, outputType);
        }
    }

    private void writeOptionClass(Option option, OptionTree tree, OptionClassWriter writer, OutputType outputType) throws IOException,
            JClassAlreadyExistsException
    {
        if (writer != null)
        {
            //TODO #series hack : do not write  Series, JsoSeries or MockSeries. Series field will be an array of Object
            if (option.getFullname().equals("series") 
                    //&& (outputType == OutputType.Jso || outputType == OutputType.Mock) create the Series interface
                    ) 
            {
                    return;
            }
            String pkg = ObjectOrOptionUtils.computePackageName(option, outputType, optionPackageName);
            writer.setPackageName(pkg).setOption(option);
            writer.setTree(tree);
            writer.write();
        }
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

    private static final String CONFIGURATION_FILENAME = "configuration.properties";
    private static final String GENERATOR_OUTPUT_PACKAGEPREFIX = "generator.output.packagePrefix";
    private static final String GENERATOR_OUTPUT_ROOTDIR = "generator.output.rootDir";
    private final Properties properties;
    private final String optionPackageName;

    private final Product product;

    private final String objectPackageName;
}
