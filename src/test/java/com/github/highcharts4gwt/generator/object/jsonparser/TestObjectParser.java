package com.github.highcharts4gwt.generator.object.jsonparser;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Test;

public class TestObjectParser
{

    private static final String Object1 = "object1.json";
    private static final String Object2 = "object2.json";
    private static final String Object3 = "object3.json";

    private static final String DUMP_JSON = "dump.json";

    private static final int ROOT_NUMBER = 7;

    @Test
    public void testReadOject1() throws Exception
    {
        String objectAsString = readFileAsString(this.getClass(), Object1);
        JSONObject objectAsJson = new JSONObject(objectAsString);

        com.github.highcharts4gwt.generator.object.Object object = ObjectParser.parseObject(objectAsJson);

        assertThat(object.getFullname()).isEqualTo("Axis");
        assertThat(object.getName()).isEqualTo("Axis");
        assertThat(object.getTitle()).isEqualTo("Axis");
        assertThat(object.isParent()).isTrue();
        assertThat(object.getSince()).isEmpty();
        assertThat(object.getDemo()).isEmpty();
        assertThat(object.isDeprecated()).isFalse();
        assertThat(object.getParent()).isNull();
        assertThat(object.getReturnType()).isEmpty();

        assertThat(object.getType()).isNull();
        assertThat(object.getParams()).isEmpty();
        assertThat(object.getParamsDescription()).isEmpty();
    }

    @Test
    public void testReadOject2() throws Exception
    {
        String objectAsString = readFileAsString(this.getClass(), Object2);
        JSONObject objectAsJson = new JSONObject(objectAsString);

        com.github.highcharts4gwt.generator.object.Object object = ObjectParser.parseObject(objectAsJson);

        assertThat(object.getFullname()).isEqualTo("Series.name");
        assertThat(object.getName()).isEqualTo("Series--name");
        assertThat(object.getTitle()).isEqualTo("name");
        assertThat(object.isParent()).isFalse();
        assertThat(object.getSince()).isEqualTo("1.2.0");
        assertThat(object.getDescription()).isEqualTo("The description");
        assertThat(object.isDeprecated()).isFalse();
        assertThat(object.getParent()).isEqualTo("Series"); // never empty in
                                                            // options
        assertThat(object.getReturnType()).isEqualTo("String");

        assertThat(object.getType()).isEqualTo("property");
        assertThat(object.getParams()).isNull();
        assertThat(object.getParamsDescription()).isNull();
    }

    @Test
    public void testReadOject3() throws Exception
    {
        String objectAsString = readFileAsString(this.getClass(), Object3);
        JSONObject objectAsJson = new JSONObject(objectAsString);

        com.github.highcharts4gwt.generator.object.Object object = ObjectParser.parseObject(objectAsJson);

        assertThat(object.getFullname()).isEqualTo("Axis.getExtremes");
        assertThat(object.getName()).isEqualTo("Axis--getExtremes");
        assertThat(object.getTitle()).isEqualTo("getExtremes");
        assertThat(object.isParent()).isFalse();
        assertThat(object.getSince()).isEqualTo("1.2.0");
        assertThat(object.isDeprecated()).isFalse();
        assertThat(object.getParent()).isEqualTo("Axis"); // never empty in
                                                          // options
        assertThat(object.getReturnType()).isEqualTo("Object");

        assertThat(object.getType()).isEqualTo("method");
        assertThat(object.getParams()).isEqualTo("()");
        assertThat(object.getParamsDescription()).isEqualTo("params description");
    }

    // @Test
    // public void testCreateOptions() throws Exception
    // {
    // // Given
    // String objectsAsString = readFileAsString(DUMP_JSON);
    // JSONArray objectsAsJson = new JSONArray(objectsAsString);
    //
    // // When
    // ObjectParser.parse(objectsAsJson);
    //
    // // Then
    // assertThat(options.getTrees().size()).isEqualTo(ROOT_NUMBER);
    // assertThat(options.getTrees()).contains(new OptionTree(new
    // Option("global", "", "")), new OptionTree(new Option("lang", "", "")),
    // new OptionTree(new Option("chart", "", "")), new OptionTree(new
    // Option("colors", "", "")), new OptionTree(new Option("credits", "", "")),
    // new OptionTree(new Option("drilldown", "", "")), new OptionTree(new
    // Option("exporting", "", "")), new OptionTree(new Option("labels", "",
    // "")),
    // new OptionTree(new Option("legend", "", "")), new OptionTree(new
    // Option("loading", "", "")), new OptionTree(new Option("navigation", "",
    // "")),
    // new OptionTree(new Option("noData", "", "")), new OptionTree(new
    // Option("pane", "", "")), new OptionTree(new Option("plotOptions", "",
    // "")),
    // new OptionTree(new Option("series", "", "")), new OptionTree(new
    // Option("subtitle", "", "")), new OptionTree(new Option("title", "", "")),
    // new OptionTree(new Option("tooltip", "", "")), new OptionTree(new
    // Option("xAxis", "", "")), new OptionTree(new Option("yAxis", "", "")));
    //
    // assertThat(options.findTreeWithRootFullName("colors").getParentToChildrenRelations().size()).isEqualTo(0);
    // assertThat(options.findTreeWithRootFullName("global").getParentToChildrenRelations().size()).isEqualTo(1);
    // assertThat(options.findTreeWithRootFullName("chart").getParentToChildrenRelations().size()).isEqualTo(8);
    // assertThat(options.findTreeWithRootFullName("xAxis").getParentToChildrenRelations().size()).isEqualTo(8);
    // assertThat(options.findTreeWithRootFullName("yAxis").getParentToChildrenRelations().size()).isEqualTo(5);
    // // ->
    // // yAxis.plotLines
    // // extending
    // // xAxis-plotLines
    // // etc.
    // }

    public static String readFileAsString(Class<?> klass, String filename) throws IOException
    {
        InputStream resourceAsStream = null;
        try
        {
            resourceAsStream = klass.getResourceAsStream(filename);
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
