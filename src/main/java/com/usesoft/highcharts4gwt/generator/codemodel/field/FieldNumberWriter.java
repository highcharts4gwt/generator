package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;

public class FieldNumberWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{
    private final Double defaultValue;

    public FieldNumberWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Double defaultValue)
    {
        super(codeModel, className, jClass);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, Number.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        JsoFieldHelper.writeGetterNativeCodeNumber(fieldName, Number.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, Number.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        MockFieldHelper.addGetterSetterDeclaration(fieldName, Number.class, getJclass());
        return null;
    }

}
