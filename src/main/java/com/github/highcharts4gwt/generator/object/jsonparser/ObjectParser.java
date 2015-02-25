package com.github.highcharts4gwt.generator.object.jsonparser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.highcharts4gwt.generator.object.Object;
import com.github.highcharts4gwt.generator.option.jsonparser.OptionParser;
import com.google.common.annotations.VisibleForTesting;

public class ObjectParser
{
    private static final String FIELD_FULLNAME = "fullname";

    private static final String FIELD_TITLE = "title";

    private static final String FIELD_ISPARENT = "isParent";
    private static final String FIELD_SINCE = "since";
    private static final String FIELD_DEMO = "demo";
    private static final String FIELD_DEPRECATED = "deprecated";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PARENT = "parent";
    private static final String FIELD_RETURNTYPE = "returnType";
    private static final String FIELD_DESCRIPTION = "description";

    private static final String FIELD_OBJECT_TYPE = "type";
    private static final String FIELD_OBJECT_PARAMS = "params";
    private static final String FIELD_OBJECT_PARAMSDESCRIPTION = "paramsDescription";

    private ObjectParser()
    {
    }

    public static List<Object> parse(String objectsAsString)
    {
        JSONArray jsonArray = new JSONArray(objectsAsString);

        List<Object> objects = readObjects(jsonArray);

        return objects;
    }

    @VisibleForTesting
    private static List<Object> readObjects(JSONArray jsonArray)
    {
        List<Object> objects = new ArrayList<Object>();

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jsonOption = (JSONObject) jsonArray.get(i);
            Object object = ObjectParser.parseObject(jsonOption);
            if (object != null)
                objects.add(object);
        }

        return objects;
    }

    @CheckForNull
    @VisibleForTesting
    public static Object parseObject(JSONObject jsonOption)
    {
        String fullName = OptionParser.getNonNullFieldAsString(jsonOption, FIELD_FULLNAME);

        String name = OptionParser.getNonNullFieldAsString(jsonOption, FIELD_NAME);

        String title = OptionParser.getNonNullFieldAsString(jsonOption, FIELD_TITLE);

        String type = OptionParser.getFieldAsString(jsonOption, FIELD_OBJECT_TYPE);
        String params = OptionParser.getFieldAsString(jsonOption, FIELD_OBJECT_PARAMS);
        String paramsDescription = OptionParser.getFieldAsString(jsonOption, FIELD_OBJECT_PARAMSDESCRIPTION);

        return new Object(fullName, name, title).setIsParent(Boolean.parseBoolean(OptionParser.getFieldAsString(jsonOption, FIELD_ISPARENT)))
                .setSince(OptionParser.getFieldAsString(jsonOption, FIELD_SINCE)).setDemo(OptionParser.getFieldAsString(jsonOption, FIELD_DEMO))
                .setParent(OptionParser.getFieldAsString(jsonOption, FIELD_PARENT)).setReturnType(OptionParser.getFieldAsString(jsonOption, FIELD_RETURNTYPE))
                .setDescription(OptionParser.getFieldAsString(jsonOption, FIELD_DESCRIPTION))
                .setDeprecated(Boolean.parseBoolean(OptionParser.getFieldAsString(jsonOption, FIELD_DEPRECATED))).setType(type).setParams(params)
                .setParamsDescription(paramsDescription);
    }

}
