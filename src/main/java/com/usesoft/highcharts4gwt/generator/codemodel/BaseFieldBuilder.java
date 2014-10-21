package com.usesoft.highcharts4gwt.generator.codemodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldType;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public final class BaseFieldBuilder implements FieldBuilder
{
    private static final Logger logger = LoggerFactory.getLogger(BaseClassBuilder.class);

    private JCodeModel codeModel;
    private JDefinedClass jClass;
    private String className;

    public JCodeModel getCodeModel()
    {
        return codeModel;
    }

    @Override
    public void setCodeModel(JCodeModel codeModel)
    {
        this.codeModel = codeModel;
    }

    @Override
    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassName()
    {
        return this.className;
    }

    @Override
    public void addField(Option option, OutputType outputType)
    {

        FieldType fieldType = findFieldType(option);

        fieldType.accept(new FieldWriterVisitor(option, codeModel, jClass, className), outputType);
    }

    public static FieldType findFieldType(Option option)
    {
        String returnType = option.getReturnType();

        if (returnType != null && returnType.startsWith("Array"))
            return findFieldTypeForArray(option);
        else
            return findFieldTypeForNonArray(option);
    }

    private static FieldType findFieldTypeForArray(Option option)
    {
        String returnType = option.getReturnType();
        if (returnType.equals("Array<String>"))
            return FieldType.ArrayString;
        if (returnType.equals("Array<Number>"))
            return FieldType.ArrayNumber;
        if (returnType.equals("Array<Object|Array|Number>"))
            return FieldType.Data;
        if (returnType.equals("Array"))
        {
            if (option.getFullname().equals("xAxis.categories") || option.getFullname().equals("yAxis.categories"))
                return FieldType.ArrayString;
            else
                return FieldType.ArrayNumber;
        }
        if (returnType.equals("Array<Object>"))
        {
            if (option.getFullname().equals("drilldown.series"))
            {
                // TODO treat that pseudo inheritance case
                logger.warn("drilldown.series not treated yet;");
                return FieldType.Other;
            }
            else if (!option.isParent())
            {
                return FieldType.ArrayJsonObject;
            }
            else
            {
                return FieldType.ArrayObject;
            }
        }

        logger.warn("field type not identified yet;" + option.getReturnType() + ";option;" + option);
        return FieldType.Other;
    }

    private static FieldType findFieldTypeForNonArray(Option option)
    {
        String returnType = option.getReturnType();
        if (returnType == null)
            return FieldType.Object;
        if (returnType.equals(""))
        {
            if (!option.isParent())
            {
                logger.warn("Field with empty return type;not treated;option;" + option);
                return FieldType.DoNotTreat;
            }
            else
            {
                return FieldType.Object;
            }
        }
        if (returnType.equalsIgnoreCase("Object") && !option.isParent())
            return FieldType.JsonObject;
        if (returnType.equalsIgnoreCase("Object"))
            return FieldType.Object;
        if (returnType.equalsIgnoreCase("Number"))
            return FieldType.Number;
        if (returnType.equalsIgnoreCase("String"))
            return FieldType.String;
        if (returnType.equalsIgnoreCase("Boolean"))
            return FieldType.Boolean;
        if (returnType.equalsIgnoreCase("CSSObject"))
            return FieldType.CssObject;

        logger.warn("field type not identified yet;" + option.getReturnType() + ";option;" + option);
        return FieldType.Other;
    }

    @Override
    public void setJclass(JDefinedClass jClass)
    {
        this.jClass = jClass;
    }

    protected JDefinedClass getJclass()
    {
        return jClass;
    }

}
