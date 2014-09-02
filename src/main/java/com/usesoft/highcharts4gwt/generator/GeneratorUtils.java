package com.usesoft.highcharts4gwt.generator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.CheckForNull;

import org.apache.commons.io.IOUtils;

public class GeneratorUtils
{
    private GeneratorUtils()
    {
    }

    @CheckForNull
    public static String getOptionsAsString(String highchartOptionsUrl) throws IOException
    {
        InputStream optionsInputStream = null;
        String optionsAsString;

        try
        {
            optionsInputStream = new URL(highchartOptionsUrl).openStream();
            optionsAsString = IOUtils.toString(optionsInputStream);
        }
        finally
        {
            if (optionsInputStream != null)
                optionsInputStream.close();
        }

        return optionsAsString;
    }
}
