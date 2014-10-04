package com.usesoft.highcharts4gwt.generator;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.generator.graph.OptionsData;
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionParser;

public class JsonUtils
{
    private JsonUtils()
    {
    }

    public static JSONArray extractOptions(String optionsAsString)
    {
        JSONArray options = new JSONArray(optionsAsString);
        return options;
        // JSONObject root = (JSONObject) options.get("Options");
        // return root.getJSONArray("options");
    }

    public static OptionsData createOptions(JSONArray jsonArray)
    {
        List<Option> specs = readSpecs(jsonArray);

        OptionsData options = new OptionsData();

        for (Option optionSpec : specs)
        {
            options.add(optionSpec, specs);
        }

        return options;
    }

    public static List<Option> readSpecs(JSONArray jsonArray)
    {
        List<Option> specs = new ArrayList<Option>();

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonOption = (JSONObject) jsonArray.get(i);
            Option option = OptionParser.parse(jsonOption);
            if (option != null)
                specs.add(option);
        }

        return specs;
    }

}
