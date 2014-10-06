package com.usesoft.highcharts4gwt.generator;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.CheckForNull;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usesoft.highcharts4gwt.generator.highsoft.Product;

public class OfflineGenerator extends BaseGenerator
{
    private static final Logger logger = LoggerFactory.getLogger(OfflineGenerator.class);

    public OfflineGenerator(Product product) throws IOException
    {
        super(product);
    }

    /**
     * Read files from Highcharts json file
     */
    @CheckForNull
    @Override
    public String readProductOptionsFile() throws IOException
    {
        InputStream optionsInputStream = null;
        String optionsAsString;

        try
        {
            optionsInputStream = this.getClass().getResourceAsStream("highchartsOptions.json");
            optionsAsString = IOUtils.toString(optionsInputStream);
            return optionsAsString;

        }
        finally
        {
            if (optionsInputStream != null)
                optionsInputStream.close();
        }
    }

    @Override
    protected Logger getLogger()
    {
        return logger;
    }
}
