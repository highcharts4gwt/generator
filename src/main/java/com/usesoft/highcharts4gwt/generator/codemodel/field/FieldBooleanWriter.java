package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;

public class FieldBooleanWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{

    private final boolean defaultValue;

    public FieldBooleanWriter(JCodeModel codeModel, JDefinedClass jClass, String className, boolean defaultValue, boolean pipe)
    {
        super(codeModel, className, jClass, pipe);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, fieldName, boolean.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        JsoFieldHelper.writeGetterNativeCodeBoolean(fieldName, boolean.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, boolean.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        MockFieldHelper.addGetterSetterDeclaration(fieldName, computeFieldName(fieldName), fieldName, boolean.class, getJclass());
        return null;
    }

    private String computeFieldName(String fieldName)
    {
        return fieldName + "AsBoolean";
    }

}
