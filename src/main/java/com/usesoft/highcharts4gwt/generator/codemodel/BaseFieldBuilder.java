package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldType;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

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
    public void addField(OptionSpec optionSpec, OutputType outputType)
    {
        String returnType = optionSpec.getReturnType();

        FieldType fieldType = findFieldType(optionSpec, returnType);

        fieldType.accept(new FieldWriterVisitor(optionSpec, codeModel, jClass, className), outputType);
    }

    private FieldType findFieldType(OptionSpec optionSpec, String returnType)
    {
        FieldType fieldType = findFieldTypeForSimpleFied(returnType);

        if (fieldType == null)
            fieldType = findFieldTypeForArray(optionSpec, returnType);

        if (fieldType == null)
            fieldType = FieldType.Other;

        return fieldType;
    }

    private FieldType findFieldTypeForArray(OptionSpec optionSpec, String returnType)
    {
        if (returnType.equals("Array<String>"))
            return FieldType.ArrayString;
        if (returnType.equals("Array<Number>"))
            return FieldType.ArrayNumber;
        if (returnType.equals("Array<Object>"))
        {
            JClass jClass2 = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(optionSpec, OutputType.Interface));
            if (jClass2 != null) // TODO @rqu need to treat case of
                                 // drilldown.series
                return FieldType.ArrayObject;
        }
        return null;
    }

    private FieldType findFieldTypeForSimpleFied(String returnType)
    {
        if (returnType == null)
            return FieldType.Class;
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
