package com.usesoft.highcharts4gwt.generator.codemodel.field;

import java.util.List;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldTypesVisitor implements ReturnTypeCategoryVisitor<Option, List<FieldType>>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldTypesVisitor.class);
    private final Matcher matcher;

    public static final String COLOR = "Color";
    public static final String ARRAY = "Array";
    public static final String LT = "<";
    public static final String GT = ">";
    public static final String STRING = "String";
    public static final String NUMBER = "Number";
    public static final String OBJECT = "Object";
    public static final String BOOLEAN = "Boolean";
    public static final String CSSOBJECT = "CSSObject";
    public static final String MIXED = "Mixed";
    public static final String FUNCTION = "Function";
    public static final String SERIES_STATES = "plotOptions.series.states";

    public FieldTypesVisitor(Matcher matcher)
    {
        this.matcher = matcher;
    }

    @Override
    public List<FieldType> visitSimple(Option in)
    {
        String returnType = in.getReturnType();
        List<FieldType> out = Lists.newArrayList();
        if (returnType == null)
            out.add(FieldType.Object);
        else if (returnType.equals(""))
        {
            if (!in.isParent())
            {
                logger.warn("Field with empty return type;not treated;option;" + in);
                out.add(FieldType.DoNotTreat);
            }
            else
            {
                out.add(FieldType.Object);
            }
        }
        else if (returnType.equalsIgnoreCase(OBJECT) && !in.isParent())
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
            out.add(FieldType.JsonObject);
        else if (returnType.equalsIgnoreCase(ARRAY))
        {
            // TODO ask highcharts to improve doc for those
            if (in.getFullname().equals("xAxis.categories") || in.getFullname().equals("yAxis.categories"))
                out.add(FieldType.ArrayString);
            else
                out.add(FieldType.ArrayNumber);
        }
        else if (returnType.equalsIgnoreCase(COLOR))
            out.add(FieldType.String);
        else if (returnType.equalsIgnoreCase(SERIES_STATES))
            out.add(FieldType.Object);
        else if (returnType.equalsIgnoreCase(MIXED))
        {
            fieldMixedCase(in, out);
        }
        else if (returnType.equalsIgnoreCase(FUNCTION))
        {
            fieldFunctionCase(in, out);
        }
        else
        {
            logger.warn("field type not supported yet;" + in.getReturnType() + ";option;" + in);
            out.add(FieldType.DoNotTreat);
        }

        return out;
    }

    private void fieldMixedCase(Option in, List<FieldType> out)
    {
        if (in.getTitle().equals("stack"))
        {
            out.add(FieldType.String);
            out.add(FieldType.Number);
        }
        else
        {
            // TODO support crosshairs case
            logger.warn("field type not supported yet;" + in.getReturnType() + ";option;" + in);
            out.add(FieldType.DoNotTreat);
        }
    }

    private void fieldFunctionCase(Option in, List<FieldType> out)
    {
        if (in.getFullname().contains("events"))
        {
            out.add(FieldType.Event);
        }
        else
        {
            // TODO support function case
            logger.warn("field type not supported yet;" + in.getReturnType() + ";option;" + in);
            out.add(FieldType.DoNotTreat);
        }
    }

    @Override
    public List<FieldType> visitSimpleWithPipe(Option in)
    {
        String returnType = in.getReturnType();
        List<FieldType> out = Lists.newArrayList();

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
                out.add(FieldType.JsonObject);
            else if (returnType.equalsIgnoreCase(COLOR))
                out.add(FieldType.String);
            else if (type.equalsIgnoreCase(ARRAY))
                logger.warn("field type not supported with simple pipe;" + returnType + ";option;" + in);
            else
            {
                logger.warn("field type not supported with simple pipe;" + returnType + ";option;" + in);
            }

            logger.info("field possible type;" + type + ";option;" + in);
        }

        // if (out.size() == 0)
        // {
        // logger.warn("field type not supported with pipe;" + returnType +
        // ";option;" + option);
        // out.add(FieldType.Other);
        // }

        return out;
    }

    @Override
    public List<FieldType> visitArray(Option in)
    {
        String arrayType = matcher.groupCount() > 0 ? matcher.group(1) : null;
        String matching = matcher.group(0);

        List<FieldType> out = Lists.newArrayList();
        if (matching.equals(ARRAY))
        {
            if (in.getFullname().equals("xAxis.categories") || in.getFullname().equals("yAxis.categories"))
                out.add(FieldType.ArrayString);
            else
                out.add(FieldType.ArrayNumber);
        }
        else if (arrayType.equals(STRING))
            out.add(FieldType.ArrayString);
        else if (arrayType.equals(NUMBER))
            out.add(FieldType.ArrayNumber);
        else if (arrayType.equals(COLOR))
            out.add(FieldType.ArrayString);
        else if (arrayType.equals(OBJECT))
        {
            if (in.getFullname().equals("drilldown.series"))
            {
                // TODO treat that pseudo inheritance case
                logger.warn("drilldown.series not treated yet;");
                out.add(FieldType.DoNotTreat);
            }
            else if (!in.isParent())
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
            logger.warn("field type not supported yet;" + in.getReturnType() + ";option;" + in);
            out.add(FieldType.DoNotTreat);
        }

        return out;
    }

    @Override
    public List<FieldType> visitArrayWithPipe(Option in)
    {
        String returnType = in.getReturnType();

        List<FieldType> out = Lists.newArrayList();

        for (int i = 1; i <= matcher.groupCount(); i++)
        {
            String type = matcher.group(i);
            if (type.equalsIgnoreCase(OBJECT))
                out.add(FieldType.ArrayObject);
            else if (type.equalsIgnoreCase(NUMBER))
                out.add(FieldType.ArrayNumber);
            else if (type.equalsIgnoreCase(STRING))
                out.add(FieldType.ArrayString);
            else if (type.equalsIgnoreCase(COLOR))
                out.add(FieldType.ArrayString);
            else
            {
                out.add(FieldType.DoNotTreat);
                logger.warn("array type not supported with pipe;" + returnType + ";option;" + in);
            }

            logger.info("field possible type;array<" + type + ">;option;" + in);
        }

        return out;
    }

}
