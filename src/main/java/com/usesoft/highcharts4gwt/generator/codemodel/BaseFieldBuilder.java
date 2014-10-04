package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldType;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public final class BaseFieldBuilder implements FieldBuilder
{
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
    public void addField(Option optionSpec, OutputType outputType)
    {

        FieldType fieldType = findFieldType(optionSpec);

        fieldType.accept(new FieldWriterVisitor(optionSpec, codeModel, jClass, className), outputType);
    }

    public static FieldType findFieldType(Option optionSpec)
    {
        FieldType fieldType = findFieldTypeForSimpleFied(optionSpec.getReturnType());

        if (fieldType == null)
            fieldType = findFieldTypeForArray(optionSpec);

        if (fieldType == null)
            fieldType = FieldType.Other;

        return fieldType;
    }

    private static FieldType findFieldTypeForArray(Option optionSpec)
    {
        String returnType = optionSpec.getReturnType();
        if (returnType.equals("Array<String>"))
            return FieldType.ArrayString;
        if (returnType.equals("Array<Number>"))
            return FieldType.ArrayNumber;
        if (returnType.equals("Array<Object|Array|Number>"))
            return FieldType.Data;
        // TODO treat category case
        if (returnType.equals("Array") && optionSpec.getFullname().equals("xAxis.categories"))
            return FieldType.ArrayString;
        if (returnType.equals("Array<Object>"))
        {
            // JClass jClass2 = ClassRegistry.INSTANCE.getRegistry().get(new
            // ClassRegistry.RegistryKey(optionSpec, OutputType.Interface));
            // if (jClass2 != null)

            // TODO @rqu need to treat case of
            // drilldown.series / xAxis.plotBands
            return FieldType.ArrayObject;
        }
        return null;
    }

    private static FieldType findFieldTypeForSimpleFied(String returnType)
    {
        if (returnType == null)
            return FieldType.Object;
        if (returnType.equalsIgnoreCase("Number"))
            return FieldType.Number;
        if (returnType.equalsIgnoreCase("String"))
            return FieldType.String;
        if (returnType.equalsIgnoreCase("Boolean"))
            return FieldType.Boolean;
        return null;
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
