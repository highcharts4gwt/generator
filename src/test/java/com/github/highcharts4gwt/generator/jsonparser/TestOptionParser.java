package com.github.highcharts4gwt.generator.jsonparser;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.OptionTree;
import com.github.highcharts4gwt.generator.option.OptionsData;
import com.github.highcharts4gwt.generator.option.jsonparser.OptionParser;

public class TestOptionParser
{

    private static final String Option1 = "option1.json";
    private static final String Option2 = "option2.json";
    private static final String Option3 = "option3.json";

    private static final String DUMP_JSON = "dump.json";

    private static final int ROOT_NUMBER = 20;

    @Test
    public void testReadOptionSpec1_mostlyNull() throws Exception
    {
        String optionAsString = readFileAsString(Option1);
        JSONObject optionAsJson = new JSONObject(optionAsString);

        Option option = OptionParser.parseOption(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("drilldown.activeAxisLabelStyle");
        assertThat(option.getName()).isEqualTo("drilldown--activeAxisLabelStyle");
        assertThat(option.getTitle()).isEqualTo("activeAxisLabelStyle");
        assertThat(option.getDefaults()).isNull();
        assertThat(option.getValues().size()).isEqualTo(0);
        assertThat(option.getExtending()).isNull();
        assertThat(option.getExcluding().size()).isEqualTo(0);
        assertThat(option.isParent()).isTrue();
        assertThat(option.getSince()).isNull();
        assertThat(option.getDemo()).isNull();
        assertThat(option.isDeprecated()).isFalse();
        assertThat(option.getSeeAlso()).isNull();
        assertThat(option.getParent()).isNull();
        assertThat(option.getReturnType()).isNull();
        assertThat(option.getDescription()).isNull();
    }

    @Test
    public void testReadOptionSpec2_mostlyEmpty() throws Exception
    {
        String optionAsString = readFileAsString(Option2);
        JSONObject optionAsJson = new JSONObject(optionAsString);

        Option option = OptionParser.parseOption(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("global.VMLRadialGradientURL");
        assertThat(option.getName()).isEqualTo("global--VMLRadialGradientURL");
        assertThat(option.getTitle()).isEqualTo("VMLRadialGradientURL");
        assertThat(option.getDefaults()).isEmpty();
        assertThat(option.getValues().size()).isEqualTo(0);
        assertThat(option.getExtending()).isEmpty();
        assertThat(option.getExcluding().size()).isEqualTo(0);
        assertThat(option.isParent()).isFalse();
        assertThat(option.getSince()).isEmpty();
        assertThat(option.getDemo()).isEmpty();
        assertThat(option.isDeprecated()).isFalse();
        assertThat(option.getSeeAlso()).isEmpty();
        assertThat(option.getParent()).isNull(); // never empty in options
        assertThat(option.getReturnType()).isEmpty();
        assertThat(option.getDescription()).isEmpty();
    }

    @Test
    public void testReadOptionSpec3() throws Exception
    {
        String optionAsString = readFileAsString(Option3);
        JSONObject optionAsJson = new JSONObject(optionAsString);

        Option option = OptionParser.parseOption(optionAsJson);

        assertThat(option.getFullname()).isEqualTo("legend.align");
        assertThat(option.getName()).isEqualTo("legend--align");
        assertThat(option.getTitle()).isEqualTo("align");
        assertThat(option.getDefaults()).isEqualTo("center");
        assertThat(option.getValues().size()).isEqualTo(3);
        assertThat(option.getExtending()).isEqualTo("plotOptions-area");
        assertThat(option.getExcluding().size()).isEqualTo(3);
        assertThat(option.isParent()).isFalse();
        assertThat(option.getSince()).isEqualTo("2.3.0");
        assertThat(option.getDemo())
                .isEqualTo(
                        "<a href=\"http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/drilldown/labels/\" target=\"_blank\">Label styles</a>");
        assertThat(option.isDeprecated()).isTrue();
        assertThat(option.getSeeAlso()).isEqualTo("<a href=\"#plotOptions.column.colors\">series colors</a>");
        assertThat(option.getParent()).isEqualTo("legend");
        assertThat(option.getReturnType()).isEqualTo("String");
        assertThat(option.getDescription())
                .isEqualTo(
                        "The horizontal alignment of the legend box within the chart area. Valid values are <code>\"left\"</code>, <code>\"center\"</code> and <code>\"right\"</code>.");
    }

    @Test
    public void testCreateOptions() throws Exception
    {
        // Given
        String optionsAsString = readFileAsString(DUMP_JSON);
        new JSONArray(optionsAsString);

        // When
        OptionsData options = OptionParser.parse(optionsAsString);

        // Then
        assertThat(options.getTrees().size()).isEqualTo(ROOT_NUMBER);
        assertThat(options.getTrees()).contains(new OptionTree(new Option("global", "", "")), new OptionTree(new Option("lang", "", "")),
                new OptionTree(new Option("chart", "", "")), new OptionTree(new Option("colors", "", "")), new OptionTree(new Option("credits", "", "")),
                new OptionTree(new Option("drilldown", "", "")), new OptionTree(new Option("exporting", "", "")), new OptionTree(new Option("labels", "", "")),
                new OptionTree(new Option("legend", "", "")), new OptionTree(new Option("loading", "", "")), new OptionTree(new Option("navigation", "", "")),
                new OptionTree(new Option("noData", "", "")), new OptionTree(new Option("pane", "", "")), new OptionTree(new Option("plotOptions", "", "")),
                new OptionTree(new Option("series", "", "")), new OptionTree(new Option("subtitle", "", "")), new OptionTree(new Option("title", "", "")),
                new OptionTree(new Option("tooltip", "", "")), new OptionTree(new Option("xAxis", "", "")), new OptionTree(new Option("yAxis", "", "")));

        assertThat(options.findTreeWithRootFullName("colors").getParentToChildrenRelations().size()).isEqualTo(0);
        assertThat(options.findTreeWithRootFullName("global").getParentToChildrenRelations().size()).isEqualTo(1);
        assertThat(options.findTreeWithRootFullName("chart").getParentToChildrenRelations().size()).isEqualTo(8);
        assertThat(options.findTreeWithRootFullName("xAxis").getParentToChildrenRelations().size()).isEqualTo(8);
        assertThat(options.findTreeWithRootFullName("yAxis").getParentToChildrenRelations().size()).isEqualTo(5); // ->
        // yAxis.plotLines
        // extending
        // xAxis-plotLines
        // etc.
    }

    private String readFileAsString(String filename) throws IOException
    {
        InputStream resourceAsStream = null;
        try
        {
            resourceAsStream = this.getClass().getResourceAsStream(filename);
            String optionsAsString = IOUtils.toString(resourceAsStream);
            return optionsAsString;
        }
        finally
        {
            if (resourceAsStream != null)
                resourceAsStream.close();
        }
    }
}
