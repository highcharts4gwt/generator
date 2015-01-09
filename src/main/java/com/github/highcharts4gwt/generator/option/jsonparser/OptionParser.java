package com.github.highcharts4gwt.generator.option.jsonparser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.OptionsData;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

public class OptionParser
{
    private static final String SHOULD_NOT_BE_NULL = " should not be null.";

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

    private OptionParser()
    {
    }

    public static OptionsData parse(String optionsAsString)
    {
        JSONArray jsonArray = new JSONArray(optionsAsString);

        List<Option> options = readOptions(jsonArray);

        OptionsData optionsData = new OptionsData();

        for (Option option : options)
        {
            optionsData.add(option, options);
        }

        return optionsData;
    }

    @VisibleForTesting
    private static List<Option> readOptions(JSONArray jsonArray)
    {
        List<Option> options = new ArrayList<Option>();

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonOption = (JSONObject) jsonArray.get(i);
            Option option = OptionParser.parseOption(jsonOption);
            if (option != null)
                options.add(option);
        }

        return options;
    }

    @CheckForNull
    @VisibleForTesting
    public static Option parseOption(JSONObject jsonOption)
    {
        String fullName = getNonNullFieldAsString(jsonOption, FIELD_FULLNAME);

        String name = getNonNullFieldAsString(jsonOption, FIELD_NAME);

        String title = getNonNullFieldAsString(jsonOption, FIELD_TITLE);

        List<String> values = getFieldAsListString(jsonOption, FIELD_VALUES);
        List<String> excluding = getFieldAsListString(jsonOption, FIELD_EXCLUDING);

        return new Option(fullName, name, title).setValues(values).setDefaults(getFieldAsString(jsonOption, FIELD_DEFAULTS))
                .setExtending(getFieldAsString(jsonOption, FIELD_EXTENDING)).setExcluding(excluding)
                .setIsParent(Boolean.parseBoolean(getFieldAsString(jsonOption, FIELD_ISPARENT))).setSince(getFieldAsString(jsonOption, FIELD_SINCE))
                .setDemo(getFieldAsString(jsonOption, FIELD_DEMO)).setSeeAlso(getFieldAsString(jsonOption, FIELD_SEEALSO))
                .setParent(getFieldAsString(jsonOption, FIELD_PARENT)).setReturnType(getFieldAsString(jsonOption, FIELD_RETURNTYPE))
                .setDescription(getFieldAsString(jsonOption, FIELD_DESCRIPTION))
                .setDeprecated(Boolean.parseBoolean(getFieldAsString(jsonOption, FIELD_DEPRECATED)));
    }

    @CheckForNull
    public static String getFieldAsString(JSONObject jsonOption, String fieldName)
    {
        // TODO Report to HS - Need to trim because some values with ' '
        String value = jsonOption.get(fieldName).toString().trim();
        if (value.equals(NULL))
            return null;
        return value;
    }

    public static String getNonNullFieldAsString(JSONObject jsonOption, String fieldName)
    {
        String value = jsonOption.get(fieldName).toString().trim();
        if (value.equals(NULL))
            throw new RuntimeException(fieldName + SHOULD_NOT_BE_NULL);
        return value;
    }

    public static List<String> getFieldAsListString(JSONObject jsonOption, String fieldName)
    {
        String valuesAsString = jsonOption.get(fieldName).toString().trim();

        if (Strings.isNullOrEmpty(valuesAsString) || valuesAsString.equals(NULL))
            return new ArrayList<String>();

        valuesAsString = valuesAsString.replace("[", "");
        valuesAsString = valuesAsString.replace("]", "");
        valuesAsString = valuesAsString.replace("\"", "");
        return Splitter.on(",").trimResults().splitToList(valuesAsString);
    }
}
