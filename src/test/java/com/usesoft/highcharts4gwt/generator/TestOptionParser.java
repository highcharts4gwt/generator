package com.usesoft.highcharts4gwt.generator;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Test;

import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionParser;

public class TestOptionParser
{

    private static final String OptionWithDefaultsNull = "nodeWithDefaultsNull.json";
    private static final String OptionWithNoValues = "nodeWithNoValues.json";
    private static final String OptionWithValues = "nodeWithValues.json";

    @Test
    public void testReadOptionSpec1() throws Exception
    {
        JSONObject optionAsJson = extractOption(OptionWithDefaultsNull);

        OptionSpec option = OptionParser.parse(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("drilldown.activeAxisLabelStyle");
        assertThat(option.getName()).isEqualTo("drilldown--activeAxisLabelStyle");
        assertThat(option.getTitle()).isEqualTo("activeAxisLabelStyle");
        assertThat(option.getValues().size()).isEqualTo(0);
    }

    @Test
    public void testReadOptionSpec2() throws Exception
    {
        JSONObject optionAsJson = extractOption(OptionWithNoValues);

        OptionSpec option = OptionParser.parse(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("global.VMLRadialGradientURL");
        assertThat(option.getName()).isEqualTo("global--VMLRadialGradientURL");
        assertThat(option.getTitle()).isEqualTo("VMLRadialGradientURL");
        assertThat(option.getValues().size()).isEqualTo(0);
    }

    @Test
    public void testReadOptionSpec3() throws Exception
    {
        JSONObject optionAsJson = extractOption(OptionWithValues);

        OptionSpec option = OptionParser.parse(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("legend.align");
        assertThat(option.getName()).isEqualTo("legend--align");
        assertThat(option.getTitle()).isEqualTo("align");
        assertThat(option.getValues().size()).isEqualTo(3);
    }

    private JSONObject extractOption(String filename) throws IOException
    {
        InputStream resourceAsStream = null;
        try
        {
            resourceAsStream = this.getClass().getResourceAsStream(filename);
            String optionsAsString = IOUtils.toString(resourceAsStream);
            JSONObject option = new JSONObject(optionsAsString);
            return option;

        } finally
        {
            if (resourceAsStream != null)
                resourceAsStream.close();
        }
    }
}
