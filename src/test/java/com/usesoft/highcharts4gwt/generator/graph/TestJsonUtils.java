package com.usesoft.highcharts4gwt.generator.graph;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.junit.Test;

import com.usesoft.highcharts4gwt.generator.JsonUtils;

public class TestJsonUtils
{
    private static final String DUMP_JSON = "dump.json";

    private static final int OPTIONS_NUMBER = 685;
    private static final int ROOT_NUMBER = 20;

    @Test
    public void testExtractOptions() throws Exception
    {
        JSONArray extractedOptions = extractOptions();

        assertThat(extractedOptions.length()).isEqualTo(OPTIONS_NUMBER);
    }

    @Test
    public void testReadSpecs() throws Exception
    {
        // Given
        JSONArray extractedOptions = extractOptions();

        // When
        List<Option> nodes = JsonUtils.readSpecs(extractedOptions);

        // Then
        assertThat(nodes.size()).isEqualTo(OPTIONS_NUMBER);
    }

    @Test
    public void testCreateOptions() throws Exception
    {
        // Given
        JSONArray extractedOptions = extractOptions();

        // When
        OptionsData options = JsonUtils.createOptions(extractedOptions);

        // Then
        assertThat(options.getTrees().size()).isEqualTo(ROOT_NUMBER);
        assertThat(options.getTrees()).contains(new OptionTree(new Option("global", "", "")), new OptionTree(new Option("lang", "", "")),
                new OptionTree(new Option("chart", "", "")), new OptionTree(new Option("colors", "", "")), new OptionTree(new Option("credits", "", "")),
                new OptionTree(new Option("drilldown", "", "")), new OptionTree(new Option("exporting", "", "")), new OptionTree(new Option("labels", "", "")),
                new OptionTree(new Option("legend", "", "")), new OptionTree(new Option("loading", "", "")), new OptionTree(new Option("navigation", "", "")),
                new OptionTree(new Option("noData", "", "")), new OptionTree(new Option("pane", "", "")), new OptionTree(new Option("plotOptions", "", "")),
                new OptionTree(new Option("series", "", "")), new OptionTree(new Option("subtitle", "", "")), new OptionTree(new Option("title", "", "")),
                new OptionTree(new Option("tooltip", "", "")), new OptionTree(new Option("xAxis", "", "")), new OptionTree(new Option("yAxis", "", "")));

        assertThat(options.findTree("colors").getParentToChildrenRelations().size()).isEqualTo(0);
        assertThat(options.findTree("global").getParentToChildrenRelations().size()).isEqualTo(1);
        assertThat(options.findTree("chart").getParentToChildrenRelations().size()).isEqualTo(8);
        assertThat(options.findTree("xAxis").getParentToChildrenRelations().size()).isEqualTo(8);
        assertThat(options.findTree("yAxis").getParentToChildrenRelations().size()).isEqualTo(5); // ->
                                                                                                  // yAxis.plotLines
                                                                                                  // extending
                                                                                                  // xAxis-plotLines
                                                                                                  // etc.
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
