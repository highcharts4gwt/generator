package com.usesoft.highcharts4gwt.generator.codemodel.field;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldTypeHelper
{
    private static final String COLOR = "Color";
    private static final String ARRAY = "Array";
    private static final String LT = "<";
    private static final String GT = ">";
    private static final String STRING = "String";
    private static final String NUMBER = "Number";
    private static final String OBJECT = "Object";
    private static final String BOOLEAN = "Boolean";
    private static final String CSSOBJECT = "CSSObject";

    private static final Logger logger = LoggerFactory.getLogger(FieldTypeHelper.class);

    private static final Pattern PIPE_REGEXP = Pattern.compile("(\\w+)\\s*(?:\\|\\s*(\\w+))+");
    private static final Pattern ARRAY_REGEXP = Pattern.compile("Array(\\s)*<\\s*(\\w+)\\s*>");
    private static final Pattern ARRAY_PIPE_REGEXP = Pattern.compile("Array\\s*<\\s*(\\w+)\\s*(?:\\|\\s*(\\w+)\\s*)+>");

    private FieldTypeHelper()
    {
    }

    public static List<FieldType> findTypes(Option option)
    {
        String returnType = option.getReturnType();

        if (!Strings.isNullOrEmpty(returnType))
        {
            Matcher matcherArrayPipe = ARRAY_PIPE_REGEXP.matcher(returnType);
            if (matcherArrayPipe.matches())
                return findFieldTypesForArrayPipe(option, matcherArrayPipe);

            Matcher matcherArray = ARRAY_REGEXP.matcher(returnType);
            if (matcherArray.matches())
                return findFieldTypeForArray(option);

            Matcher matcherPipe = PIPE_REGEXP.matcher(returnType);
            if (matcherPipe.matches())
                return findFieldTypesSimplePipe(option, matcherPipe);
        }
        return findFieldTypeSimple(option);
    }

    private static List<FieldType> findFieldTypesForArrayPipe(Option option, Matcher matcher)
    {
        List<FieldType> out = Lists.newArrayList();
        String returnType = option.getReturnType();

        for (int i = 1; i <= matcher.groupCount(); i++)
        {
            String type = matcher.group(i);
            if (type.equalsIgnoreCase(OBJECT))
                out.add(FieldType.ArrayObject);
            else if (type.equalsIgnoreCase(NUMBER))
                out.add(FieldType.ArrayNumber);
            else if (type.equalsIgnoreCase(STRING))
                out.add(FieldType.ArrayString);
            else if (returnType.equalsIgnoreCase(COLOR))
                out.add(FieldType.ArrayString);
            else
            {
                out.add(FieldType.Other);
                logger.warn("array type not supported with pipe;" + returnType + ";option;" + option);
            }

            logger.info("field possible type;array<" + type + ">;option;" + option);
        }

        return out;
    }

    private static List<FieldType> findFieldTypeForArray(Option option)
    {
        List<FieldType> out = Lists.newArrayList();
        String returnType = option.getReturnType();
        if (returnType.equals("Array<String>"))
            out.add(FieldType.ArrayString);
        else if (returnType.equals("Array<Number>"))
            out.add(FieldType.ArrayNumber);
        else if (returnType.equals("Array<Color>"))
            out.add(FieldType.ArrayString);
        else if (returnType.equals(ARRAY))
        {
            if (option.getFullname().equals("xAxis.categories") || option.getFullname().equals("yAxis.categories"))
                out.add(FieldType.ArrayString);
            else
                out.add(FieldType.ArrayNumber);
        }
        else if (returnType.equals("Array<Object>"))
        {
            if (option.getFullname().equals("drilldown.series"))
            {
                // TODO treat that pseudo inheritance case
                logger.warn("drilldown.series not treated yet;");
                out.add(FieldType.Other);
            }
            else if (!option.isParent())
            {
                out.add(FieldType.ArrayJsonObject);
            }
            else
            {
                out.add(FieldType.ArrayObject);
            }
        }
        else
        {
            logger.warn("field type not supported yet;" + option.getReturnType() + ";option;" + option);
            out.add(FieldType.Other);
        }

        return out;
    }

    private static List<FieldType> findFieldTypeSimple(Option option)
    {
        List<FieldType> out = Lists.newArrayList();
        String returnType = option.getReturnType();
        if (returnType == null)
            out.add(FieldType.Object);
        else if (returnType.equals(""))
        {
            if (!option.isParent())
            {
                logger.warn("Field with empty return type;not treated;option;" + option);
                out.add(FieldType.DoNotTreat);
            }
            else
            {
                out.add(FieldType.Object);
            }
        }
        else if (returnType.equalsIgnoreCase(OBJECT) && !option.isParent())
            out.add(FieldType.JsonObject);
        else if (returnType.equalsIgnoreCase(OBJECT))
            out.add(FieldType.Object);
        else if (returnType.equalsIgnoreCase(NUMBER))
            out.add(FieldType.Number);
        else if (returnType.equalsIgnoreCase(STRING))
            out.add(FieldType.String);
        else if (returnType.equalsIgnoreCase(BOOLEAN))
            out.add(FieldType.Boolean);
        else if (returnType.equalsIgnoreCase(CSSOBJECT))
            out.add(FieldType.CssObject);
        else if (returnType.equalsIgnoreCase(ARRAY))
        {
            // TODO ask highcharts to improve doc for those
            if (option.getFullname().equals("xAxis.categories") || option.getFullname().equals("yAxis.categories"))
                out.add(FieldType.ArrayString);
            else
                out.add(FieldType.ArrayNumber);
        }
        else if (returnType.equalsIgnoreCase(COLOR))
            out.add(FieldType.String);
        else
        {
            logger.warn("field type not supported yet;" + option.getReturnType() + ";option;" + option);
            out.add(FieldType.Other);
        }

        return out;
    }

    private static List<FieldType> findFieldTypesSimplePipe(Option option, Matcher matcher)
    {
        List<FieldType> out = Lists.newArrayList();
        String returnType = option.getReturnType();

        for (int i = 1; i <= matcher.groupCount(); i++)
        {
            String type = matcher.group(i);
            if (type.equalsIgnoreCase(OBJECT))
                out.add(FieldType.JsonObject);
            else if (type.equalsIgnoreCase(NUMBER))
                out.add(FieldType.Number);
            else if (type.equalsIgnoreCase(STRING))
                out.add(FieldType.String);
            else if (type.equalsIgnoreCase(BOOLEAN))
                out.add(FieldType.Boolean);
            else if (type.equalsIgnoreCase(CSSOBJECT))
                out.add(FieldType.CssObject);
            else if (returnType.equalsIgnoreCase(COLOR))
                out.add(FieldType.String);
            else if (type.equalsIgnoreCase(ARRAY))
                logger.warn("field type not supported with simple pipe;" + returnType + ";option;" + option);
            else
            {
                logger.warn("field type not supported with simple pipe;" + returnType + ";option;" + option);
            }

            logger.info("field possible type;" + type + ";option;" + option);
        }

        // if (out.size() == 0)
        // {
        // logger.warn("field type not supported with pipe;" + returnType +
        // ";option;" + option);
        // out.add(FieldType.Other);
        // }

        return out;
    }
}
