package com.github.highcharts4gwt.generator.common.field;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.github.highcharts4gwt.generator.object.jsonparser.TestObjectParser;
import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.jsonparser.OptionParser;

public class TestFieldTypeHelper
{

    // private Option option1;

    @Before
    public void setup()
    {
        // String option1AsString = "\"{" + "\"values\": null," +
        // "\"fullname\": \"drilldown.activeAxisLabelStyle\"," +
        // "\"defaults\": null,"
        // + "\"title\": \"activeAxisLabelStyle\"," + "\"extending\": null," +
        // "\"excluding\": null," + "\"isParent\": true," + "\"since\": null,"
        // + "\"demo\": null," + "\"deprecated\": null," + "\"seeAlso\": null,"
        // + "\"name\": \"drilldown--activeAxisLabelStyle\"," +
        // "\"parent\": null,"
        // + "\"returnType\": null," + "\"description\": null" + "}\"";
        //
        // JSONObject object1AsJson = new JSONObject(option1AsString);

        // option1 = OptionParser.parseOption(object1AsJson);
    }

    @Test
    public void testTypeString() throws Exception
    {
        // Given
        Option option = parseOption("option1.json");

        // When
        List<FieldType> types = FieldTypeHelper.findTypes(option);

        // Then
        assertThat(types.size()).isEqualTo(1);
        assertThat(types.get(0)).isEqualTo(FieldType.String);
    }

    private Option parseOption(String fileName) throws IOException
    {
        String optionAsString = TestObjectParser.readFileAsString(this.getClass(), fileName);
        JSONObject objectAsJson = new JSONObject(optionAsString);
        Option option = OptionParser.parseOption(objectAsJson);
        return option;
    }

    // @Test
    // public void testTypeNumer() throws Exception
    // {
    // // Given
    // Option option = parseOption("option2.json");
    //
    // // When
    // List<FieldType> types = FieldTypeHelper.findTypes(option);
    //
    // // Then
    // assertThat(types.size()).isEqualTo(1);
    // assertThat(types.get(0)).isEqualTo(FieldType.Number);
    //
    // }
}
