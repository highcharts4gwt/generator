package com.github.highcharts4gwt.generator;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.CheckForNull;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.model.highsoft.ConfigurationType;
import com.github.highcharts4gwt.generator.model.highsoft.Product;

public class OfflineGenerator extends BaseGenerator
{
    private static final Logger logger = LoggerFactory.getLogger(OfflineGenerator.class);

    public OfflineGenerator(Product product) throws IOException
    {
        super(product, ConfigurationType.Option);
    }

    /**
     * Read files from Highcharts json file
     */
    @CheckForNull
    @Override
    public String readProductOptionsFile() throws IOException
    {
        String fileName = "highchartsOptions.json";

        return fetchFileFromFileName(fileName);
    }

    /**
     * Read files from Highcharts json file
     */
    @CheckForNull
    @Override
    public String readProductObjectsFile() throws IOException
    {
        String fileName = "highchartsObjects.json";

        return fetchFileFromFileName(fileName);
    }

    private String fetchFileFromFileName(String fileName) throws IOException
    {
        InputStream inputStream = null;
        String streamAsString;

        try
        {
            inputStream = this.getClass().getResourceAsStream(fileName);
            streamAsString = IOUtils.toString(inputStream);
            return streamAsString;

        }
        finally
        {
            if (inputStream != null)
                inputStream.close();
        }
    }

    @Override
    protected Logger getLogger()
    {
        return logger;
    }
}
