package com.usesoft.highcharts4gwt.generator;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.junit.Test;

import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public class TestJsonUtils
{
    private static final String DUMP_JSON = "dump.json";

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
}
