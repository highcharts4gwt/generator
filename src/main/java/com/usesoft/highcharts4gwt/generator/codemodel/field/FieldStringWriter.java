package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;

public class FieldStringWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{

    private final String defaultValue;

    public FieldStringWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue)
    {
        super(codeModel, className, jClass);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, String.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        JsoFieldHelper.writeGetterNativeCodeString(fieldName, String.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, String.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        MockFieldHelper.addGetterSetterDeclaration(fieldName, String.class, getJclass());
        return null;
    }

}
