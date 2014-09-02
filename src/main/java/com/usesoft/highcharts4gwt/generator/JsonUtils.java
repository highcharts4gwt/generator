package com.usesoft.highcharts4gwt.generator;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.usesoft.highcharts4gwt.generator.graph.GraphMultiRoot;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
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

    public static GraphMultiRoot createGraph(JSONArray jsonArray)
    {
        GraphMultiRoot graph = new GraphMultiRoot();
        createNodes(jsonArray);

        return graph;
    }

    public static List<OptionSpec> createNodes(JSONArray jsonArray)
    {
        List<OptionSpec> nodes = new ArrayList<OptionSpec>();

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonOption = (JSONObject) jsonArray.get(i);
            nodes.add(OptionParser.parse(jsonOption));
        }

        return nodes;
    }

}
