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
    private Matcher matcher;

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
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.OBJECT) && !in.isParent())
            out.add(FieldType.JsonObject);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.OBJECT))
            out.add(FieldType.Object);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.NUMBER))
            out.add(FieldType.Number);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.STRING))
            out.add(FieldType.String);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.BOOLEAN))
            out.add(FieldType.Boolean);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.CSSOBJECT))
            out.add(FieldType.JsonObject);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.ARRAY))
        {
            // TODO ask highcharts to improve doc for those
            if (in.getFullname().equals("xAxis.categories") || in.getFullname().equals("yAxis.categories"))
                out.add(FieldType.ArrayString);
            else
                out.add(FieldType.ArrayNumber);
        }
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.COLOR))
            out.add(FieldType.String);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.SERIES_STATES))
            out.add(FieldType.Object);
        else if (returnType.equalsIgnoreCase(FieldTypeHelper.MIXED))
        {
            treatMixedCase(in, out);
        }
        else
        {
            logger.warn("field type not supported yet;" + in.getReturnType() + ";option;" + in);
            out.add(FieldType.DoNotTreat);
        }

        return out;
    }

    private void treatMixedCase(Option in, List<FieldType> out)
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

    @Override
    public List<FieldType> visitSimpleWithPipe(Option in)
    {
        String returnType = in.getReturnType();
        List<FieldType> out = Lists.newArrayList();

        for (int i = 1; i <= matcher.groupCount(); i++)
        {
            String type = matcher.group(i);
            if (type.equalsIgnoreCase(FieldTypeHelper.OBJECT))
                out.add(FieldType.JsonObject);
            else if (type.equalsIgnoreCase(FieldTypeHelper.NUMBER))
                out.add(FieldType.Number);
            else if (type.equalsIgnoreCase(FieldTypeHelper.STRING))
                out.add(FieldType.String);
            else if (type.equalsIgnoreCase(FieldTypeHelper.BOOLEAN))
                out.add(FieldType.Boolean);
            else if (type.equalsIgnoreCase(FieldTypeHelper.CSSOBJECT))
                out.add(FieldType.JsonObject);
            else if (returnType.equalsIgnoreCase(FieldTypeHelper.COLOR))
                out.add(FieldType.String);
            else if (type.equalsIgnoreCase(FieldTypeHelper.ARRAY))
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
        if (matching.equals(FieldTypeHelper.ARRAY))
        {
            if (in.getFullname().equals("xAxis.categories") || in.getFullname().equals("yAxis.categories"))
                out.add(FieldType.ArrayString);
            else
                out.add(FieldType.ArrayNumber);
        }
        else if (arrayType.equals(FieldTypeHelper.STRING))
            out.add(FieldType.ArrayString);
        else if (arrayType.equals(FieldTypeHelper.NUMBER))
            out.add(FieldType.ArrayNumber);
        else if (arrayType.equals(FieldTypeHelper.COLOR))
            out.add(FieldType.ArrayString);
        else if (arrayType.equals(FieldTypeHelper.OBJECT))
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
            if (type.equalsIgnoreCase(FieldTypeHelper.OBJECT))
                out.add(FieldType.ArrayObject);
            else if (type.equalsIgnoreCase(FieldTypeHelper.NUMBER))
                out.add(FieldType.ArrayNumber);
            else if (type.equalsIgnoreCase(FieldTypeHelper.STRING))
                out.add(FieldType.ArrayString);
            else if (type.equalsIgnoreCase(FieldTypeHelper.COLOR))
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
