package com.usesoft.highcharts4gwt.generator;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Test;

import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionParser;

public class TestOptionParser
{

    private static final String Option1 = "option1.json";
    private static final String Option2 = "option2.json";
    private static final String Option3 = "option3.json";

    @Test
    public void testReadOptionSpec1_mostlyNull() throws Exception
    {
        JSONObject optionAsJson = extractOption(Option1);

        Option option = OptionParser.parse(optionAsJson);

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
        JSONObject optionAsJson = extractOption(Option2);

        Option option = OptionParser.parse(optionAsJson);

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
        JSONObject optionAsJson = extractOption(Option3);

        Option option = OptionParser.parse(optionAsJson);

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
