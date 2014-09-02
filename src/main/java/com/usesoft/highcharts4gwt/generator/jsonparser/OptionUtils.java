package com.usesoft.highcharts4gwt.generator.jsonparser;

import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public class OptionUtils
{
    private OptionUtils()
    {
    }

    public static String extractRootFullName(OptionSpec option)
    {
        return option.getFullname().split("\\.")[0];
    }
}
