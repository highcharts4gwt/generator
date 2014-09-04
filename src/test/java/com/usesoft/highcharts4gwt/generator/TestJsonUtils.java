package com.usesoft.highcharts4gwt.generator;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.junit.Test;

import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;
import com.usesoft.highcharts4gwt.generator.graph.Options;

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
        List<OptionSpec> nodes = JsonUtils.readSpecs(extractedOptions);

        // Then
        assertThat(nodes.size()).isEqualTo(OPTIONS_NUMBER);
    }

    @Test
    public void testCreateOptions() throws Exception
    {
        // Given
        JSONArray extractedOptions = extractOptions();

        // When
        Options options = JsonUtils.createOptions(extractedOptions);

        // Then
        assertThat(options.getTrees().size()).isEqualTo(ROOT_NUMBER);
        assertThat(options.getTrees()).contains(new OptionTree(new OptionSpec("global", "", "")), new OptionTree(new OptionSpec("lang", "", "")),
                        new OptionTree(new OptionSpec("chart", "", "")), new OptionTree(new OptionSpec("colors", "", "")),
                        new OptionTree(new OptionSpec("credits", "", "")), new OptionTree(new OptionSpec("drilldown", "", "")),
                        new OptionTree(new OptionSpec("exporting", "", "")), new OptionTree(new OptionSpec("labels", "", "")),
                        new OptionTree(new OptionSpec("legend", "", "")), new OptionTree(new OptionSpec("loading", "", "")),
                        new OptionTree(new OptionSpec("navigation", "", "")), new OptionTree(new OptionSpec("noData", "", "")),
                        new OptionTree(new OptionSpec("pane", "", "")), new OptionTree(new OptionSpec("plotOptions", "", "")),
                        new OptionTree(new OptionSpec("series", "", "")), new OptionTree(new OptionSpec("subtitle", "", "")),
                        new OptionTree(new OptionSpec("title", "", "")), new OptionTree(new OptionSpec("tooltip", "", "")),
                        new OptionTree(new OptionSpec("xAxis", "", "")), new OptionTree(new OptionSpec("yAxis", "", "")));

        assertThat(options.findTree("colors").getParentToChildrenRelations().size()).isEqualTo(0);
        assertThat(options.findTree("global").getParentToChildrenRelations().size()).isEqualTo(1);
        assertThat(options.findTree("chart").getParentToChildrenRelations().size()).isEqualTo(8);
        assertThat(options.findTree("xAxis").getParentToChildrenRelations().size()).isEqualTo(8);
        assertThat(options.findTree("yAxis").getParentToChildrenRelations().size()).isEqualTo(5); // -> yAxis.plotLines extending xAxis-plotLines etc.
    }

    private JSONArray extractOptions() throws IOException
    {
        InputStream resourceAsStream = null;
        try
        {
            resourceAsStream = this.getClass().getResourceAsStream(DUMP_JSON);
            String optionsAsString = IOUtils.toString(resourceAsStream);
            return JsonUtils.extractOptions(optionsAsString);

        }
        finally
        {
            if (resourceAsStream != null)
                resourceAsStream.close();
        }
    }
}
