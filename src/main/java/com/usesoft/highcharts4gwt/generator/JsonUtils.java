package com.usesoft.highcharts4gwt.generator;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.graph.Options;
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionParser;

public class JsonUtils
{
    private JsonUtils()
    {
    }

    public static JSONArray extractOptions(String optionsAsString)
    {
        JSONObject options = new JSONObject(optionsAsString);
        JSONObject root = (JSONObject) options.get("Options");
        return root.getJSONArray("options");
    }

    public static Options createOptions(JSONArray jsonArray)
    {
        List<OptionSpec> specs = readSpecs(jsonArray);

        Options options = new Options();

        for (OptionSpec optionSpec : specs)
        {
            options.add(optionSpec, specs);
        }

        return options;
    }

    public static List<OptionSpec> readSpecs(JSONArray jsonArray)
    {
        List<OptionSpec> specs = new ArrayList<OptionSpec>();

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonOption = (JSONObject) jsonArray.get(i);
            OptionSpec option = OptionParser.parse(jsonOption);
            if (option != null)
                specs.add(option);
        }

        return specs;
    }

}
