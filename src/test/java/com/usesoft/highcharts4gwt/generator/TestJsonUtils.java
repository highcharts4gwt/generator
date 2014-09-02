package com.usesoft.highcharts4gwt.generator;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionParser;

public class TestJsonUtils
{
    private static final String DUMP_JSON = "dump.json";

    private static final String OptionWithDefaultsNull = "nodeWithDefaultsNull.json";
    private static final String OptionWithNoValues = "nodeWithNoValues.json";
    private static final String OptionWithValues = "nodeWithValues.json";

    private static final int OPTIONS_NUMBER = 681;

    @Test
    public void testExtractOptions() throws Exception
    {
        JSONArray extractedOptions = extractOptions();

        assertThat(extractedOptions.length()).isEqualTo(681);
    }

    @Test
    public void testCreateNodes() throws Exception
    {
        JSONArray extractedOptions = extractOptions();

        List<OptionSpec> nodes = JsonUtils.createNodes(extractedOptions);

        assertThat(nodes.size()).isEqualTo(OPTIONS_NUMBER);
    }

    @Test
    public void testReadOptionSpec1() throws Exception
    {
        JSONObject optionAsJson = extractOption(OptionWithDefaultsNull);

        OptionSpec option = OptionParser.parse(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("drilldown.activeAxisLabelStyle");
        assertThat(option.getName()).isEqualTo("drilldown--activeAxisLabelStyle");
        assertThat(option.getTitle()).isEqualTo("activeAxisLabelStyle");
    }

    @Test
    public void testReadOptionSpec2() throws Exception
    {
        JSONObject optionAsJson = extractOption(OptionWithNoValues);

        OptionSpec option = OptionParser.parse(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("global.VMLRadialGradientURL");
        assertThat(option.getName()).isEqualTo("global--VMLRadialGradientURL");
        assertThat(option.getTitle()).isEqualTo("VMLRadialGradientURL");
    }

    @Test
    public void testReadOptionSpec3() throws Exception
    {
        JSONObject optionAsJson = extractOption(OptionWithValues);

        OptionSpec option = OptionParser.parse(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("legend.align");
        assertThat(option.getName()).isEqualTo("legend--align");
        assertThat(option.getTitle()).isEqualTo("align");
    }

    private JSONArray extractOptions() throws IOException
    {
        InputStream resourceAsStream = null;
        try
        {
            resourceAsStream = this.getClass().getResourceAsStream(DUMP_JSON);
            String optionsAsString = IOUtils.toString(resourceAsStream);
            return JsonUtils.extractOptions(optionsAsString);

        } finally
        {
            if (resourceAsStream != null)
                resourceAsStream.close();
        }
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
