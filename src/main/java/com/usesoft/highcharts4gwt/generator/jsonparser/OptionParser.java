package com.usesoft.highcharts4gwt.generator.jsonparser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public class OptionParser
{
    private static final String NULL = "null";
    private static final String FIELD_FULLNAME = "fullname";
    private static final String FIELD_VALUES = "values";
    private static final String FIELD_DEFAULTS = "defaults";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_EXTENDING = "extending";
    private static final String FIELD_EXCLUDING = "excluding";
    private static final String FIELD_ISPARENT = "isParent";
    private static final String FIELD_SINCE = "since";
    private static final String FIELD_DEMO = "demo";
    private static final String FIELD_DEPRECATED = "deprecated";
    private static final String FIELD_SEEALSO = "seeAlso";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PARENT = "parent";
    private static final String FIELD_RETURNTYPE = "returnType";
    private static final String FIELD_DESCRIPTION = "description";

    // {
    // values: null,
    // fullname: "global.VMLRadialGradientURL",
    // defaults:
    // "http://code.highcharts.com/{version}/gfx/vml-radial-gradient.png",
    // title: "VMLRadialGradientURL",
    // extending: "",
    // excluding: "",
    // isParent: false,
    // since: "2.3.0",
    // demo: "",
    // deprecated: false,
    // seeAlso: "",
    // name: "global--VMLRadialGradientURL",
    // parent: "global",
    // returnType: "String",
    // description:
    // "Path to the pattern image required by VML browsers in order to draw radial gradients."
    // }

    private OptionParser()
    {
    }

    public static OptionSpec parse(JSONObject jsonOption)
    {
        String fullName = getOptionValue(jsonOption, FIELD_FULLNAME);
        String name = getOptionValue(jsonOption, FIELD_NAME);
        String title = getOptionValue(jsonOption, FIELD_TITLE);

        List<String> values = parseList(jsonOption, FIELD_VALUES);
        List<String> excluding = parseList(jsonOption, FIELD_EXCLUDING);

        OptionSpec option = new OptionSpec(fullName, name, title).setValues(values).setDefaults(getOptionValue(jsonOption, FIELD_DEFAULTS))
                        .setExtending(getOptionValue(jsonOption, FIELD_EXTENDING)).setExcluding(excluding)
                        .setIsParent(Boolean.parseBoolean(getOptionValue(jsonOption, FIELD_ISPARENT))).setSince(getOptionValue(jsonOption, FIELD_SINCE))
                        .setDemo(getOptionValue(jsonOption, FIELD_DEMO)).setDeprecated(Boolean.parseBoolean(getOptionValue(jsonOption, FIELD_DEPRECATED)))
                        .setSeeAlso(getOptionValue(jsonOption, FIELD_SEEALSO)).setParent(getOptionValue(jsonOption, FIELD_PARENT))
                        .setReturnType(getOptionValue(jsonOption, FIELD_RETURNTYPE)).setDescription(getOptionValue(jsonOption, FIELD_DESCRIPTION));

        // node.setDefaults(jsonOption.get("defaults").toString());
        // node.setDemo(jsonOption.get("defaults"));
        // node.setDeprecated(jsonOption.get("defaults"));
        // node.setDescription(jsonOption.get("defaults"));
        // node.setExcluding(jsonOption.get("defaults"));
        // node.setExtending(jsonOption.get("defaults"));
        // node.setFullname(jsonOption.get("defaults"));
        // node.setIsParent(jsonOption.get("defaults"));
        // node.setReturnType(jsonOption.get("defaults"));
        // node.setSeeAlso(jsonOption.get("defaults"));
        // node.setSince(jsonOption.get("defaults"));
        // node.setTitle(jsonOption.get("defaults"));
        // node.setValues(jsonOption.get("defaults"));
        return option;
    }

    private static String getOptionValue(JSONObject jsonOption, String fieldName)
    {
        String value = jsonOption.get(fieldName).toString();
        if (value.equals(NULL))
            return null;
        return value;
    }

    private static List<String> parseList(JSONObject jsonOption, String fieldName)
    {
        String valuesAsString = jsonOption.get(fieldName).toString();

        if (Strings.isNullOrEmpty(valuesAsString) || valuesAsString.equals(NULL))
            return new ArrayList<String>();

        valuesAsString = valuesAsString.replace("[", "");
        valuesAsString = valuesAsString.replace("]", "");
        valuesAsString = valuesAsString.replace("\"", "");
        return Splitter.on(",").trimResults().splitToList(valuesAsString);
    }
}
