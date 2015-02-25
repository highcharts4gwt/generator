package com.github.highcharts4gwt.generator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.CheckForNull;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.model.highsoft.ConfigurationType;
import com.github.highcharts4gwt.generator.model.highsoft.Product;

public class OnlineGenerator extends BaseGenerator
{
    private static final Logger logger = LoggerFactory.getLogger(OnlineGenerator.class);

    public OnlineGenerator(Product product) throws IOException
    {
        super(product, ConfigurationType.Option);
    }

    private static final String OPTIONS_FILE_PROPERTY = "highcharts.url.options";
    private static final String OBJECTS_FILE_PROPERTY = "highcharts.url.objects";

    @CheckForNull
    @Override
    public String readProductOptionsFile() throws IOException
    {
        return FetchFileFromUrl(getPropertyValue(OPTIONS_FILE_PROPERTY));
    }

    @CheckForNull
    @Override
    public String readProductObjectsFile() throws IOException
    {
        return FetchFileFromUrl(getPropertyValue(OBJECTS_FILE_PROPERTY));
    }

    private String FetchFileFromUrl(String url) throws IOException
    {
        InputStream inputStream = null;
        String streamAsString;

        try
        {
            inputStream = new URL(url).openStream();
            streamAsString = IOUtils.toString(inputStream);
        }
        finally
        {
            if (inputStream != null)
                inputStream.close();
        }

        return streamAsString;
    }

    @Override
    protected Logger getLogger()
    {
        return logger;
    }
}
