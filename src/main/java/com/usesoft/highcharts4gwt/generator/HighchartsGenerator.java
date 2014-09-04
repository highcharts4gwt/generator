package com.usesoft.highcharts4gwt.generator;

import java.io.IOException;

import com.usesoft.highcharts4gwt.highsoft.Product;

public class HighchartsGenerator extends BaseGenerator
{
    public HighchartsGenerator() throws IOException
    {
        super();
    }

    private static final String GENERATOR_INPUT_FILENAME = "highcharts.url.options";

    @Override
    public String getOptionsFileUrl() throws IOException
    {
        return getPropertyValue(GENERATOR_INPUT_FILENAME);
    }

    @Override
    public String getOutputPackageSuffix()
    {
        return Product.Highcharts.getPackageName();
    }
}
