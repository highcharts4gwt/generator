package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldType;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public abstract class BaseFieldBuilder implements FieldBuilder
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
    public void addField(OptionSpec optionSpec)
    {
        // if (optionSpec.isParent())
        // addClassField(optionSpec.getName(), optionSpec.getName());

        String returnType = optionSpec.getReturnType();

        FieldType fieldType = findFieldType(optionSpec, returnType);

        fieldType.accept(new FieldWriterVisitor(optionSpec.getTitle(), codeModel, jClass, className), getOutputType());

        // TODO switch to visitor structure

        if (returnType == null)
            addClassField(ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(optionSpec, OutputType.Interface)), optionSpec.getTitle());
        if (returnType != null && returnType.equals("Array<String>"))
            addStringArray(optionSpec.getTitle());
        if (returnType != null && returnType.equals("Array<Object|Array|Number>"))
            addNumberArray(optionSpec.getTitle());
        if (returnType != null && returnType.equals("Array<Object>"))
        {
            JClass jClass2 = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(optionSpec, OutputType.Interface));
            if (jClass2 != null) // TODO @rqu need to treat case of
                                 // drilldown.series
                addObjectArray(jClass2, optionSpec.getTitle());
        }
    }

    private FieldType findFieldType(OptionSpec optionSpec, String returnType)
    {
        if (returnType != null && returnType.equalsIgnoreCase("Number"))
            return FieldType.Number;
        if (returnType != null && returnType.equalsIgnoreCase("String"))
            return FieldType.String;
        if (returnType != null && returnType.equalsIgnoreCase("Boolean"))
            return FieldType.Boolean;

        return FieldType.Other;
    }

    @Override
    public void setJclass(JDefinedClass jClass)
    {
        this.jClass = jClass;
    }

    protected abstract OutputType getOutputType();

    // protected abstract void addNumberField(String fieldName);
    //
    // protected abstract void addStringField(String fieldName);
    //
    // protected abstract void addBooleanField(String fieldName);

    protected abstract void addObjectField(String fieldName);

    protected abstract void addFunctionField(String fieldName);

    protected abstract void addColorField(String fieldName);

    protected abstract void addMixedField(String fieldName);

    protected abstract void addCssObjectField(String fieldName);

    protected abstract void addClassField(JClass jClass, String fieldName);

    protected abstract void addStringArray(String fieldName);

    protected abstract void addNumberArray(String fieldName);

    protected abstract void addObjectArray(JClass jClass, String fieldName);

    protected JDefinedClass getJclass()
    {
        return jClass;
    }

}
