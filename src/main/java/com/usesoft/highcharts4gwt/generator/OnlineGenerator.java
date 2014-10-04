package com.usesoft.highcharts4gwt.generator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.CheckForNull;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usesoft.highcharts4gwt.generator.highsoft.Product;

public class OnlineGenerator extends BaseGenerator
{
    final static Logger logger = LoggerFactory.getLogger(OnlineGenerator.class);

    public OnlineGenerator(Product product) throws IOException
    {
        super(product);
    }

    private static final String GENERATOR_INPUT_FILENAME = "highcharts.url.options";

    /**
     * Read files from Highcharts web site
     */
    @CheckForNull
    @Override
    public String readProductOptionsFile() throws IOException
    {
        String highchartOptionsUrl = getPropertyValue(GENERATOR_INPUT_FILENAME);

        InputStream optionsInputStream = null;
        String optionsAsString;

        try
        {
            optionsInputStream = new URL(highchartOptionsUrl).openStream();
            optionsAsString = IOUtils.toString(optionsInputStream);
        } finally
        {
            if (optionsInputStream != null)
                optionsInputStream.close();
        }

        return optionsAsString;
    }

    @Override
    protected Logger getLogger()
    {
        return logger;
    }
}
