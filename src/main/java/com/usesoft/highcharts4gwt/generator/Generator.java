package com.usesoft.highcharts4gwt.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.graph.Options;

public class Generator
{

    private static final String CONFIGURATION_FILENAME = "configuration.properties";
    private static final String GENERATOR_INPUT_FILENAME = "highcharts.url.options";
    private static final String GENERATOR_OUTPUT_PACKAGENAME = "generator.output.packageName";

    public Generator()
    {
    }

    public void generate() throws IOException, JClassAlreadyExistsException
    {

        Properties properties = loadProperties();
        String packageName = getPackageName(properties);
        cleanPackage(packageName);

        createOptions(properties);

        createClasses(packageName);
    }

    private void createOptions(Properties properties) throws IOException
    {
        String optionsAsString = GeneratorUtils.getOptionsAsString(getHighchartOptionsUrl(properties));

        JSONArray jsonArray = JsonUtils.extractOptions(optionsAsString);

        Options options = JsonUtils.createOptions(jsonArray);
    }

    private void createClasses(String packageName) throws JClassAlreadyExistsException, IOException
    {

        JCodeModel codeModel = new JCodeModel();

        JDefinedClass definedClass = codeModel._class(packageName + ".ClassNameTest");
        codeModel.build(new File("."));
    }

    private void cleanPackage(String packageName) throws IOException
    {
        String path = packageName.replace(".", "/");
        FileUtils.cleanDirectory(new File(path));
    }

    private String getPackageName(Properties properties) throws IOException
    {
        return properties.getProperty(GENERATOR_OUTPUT_PACKAGENAME);
    }

    private String getHighchartOptionsUrl(Properties properties) throws IOException
    {
        return properties.getProperty(GENERATOR_INPUT_FILENAME);
    }

    private Properties loadProperties() throws IOException
    {
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream(CONFIGURATION_FILENAME);
        if (inputStream == null)
        {
            throw new FileNotFoundException("property file '" + CONFIGURATION_FILENAME + "' not found in the classpath");
        }

        properties.load(inputStream);
        return properties;
    }
}
