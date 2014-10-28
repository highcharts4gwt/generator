package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;

public class FieldJsonObjectWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{

    private final String defaultValue;

    public FieldJsonObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue, boolean pipe)
    {
        super(codeModel, className, jClass, pipe);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        String paramName = computeParamName(fieldName);

        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, paramName, fieldName, fieldName, String.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        String paramName = computeParamName(fieldName);

        JsoFieldHelper.writeGetterNativeCodeStringWithStringify(fieldName, String.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCodeWithParse(fieldName, paramName, String.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        String paramName = computeParamName(fieldName);

        MockFieldHelper.addGetterSetterDeclaration(fieldName, paramName, paramName, String.class, getJclass());
        return null;
    }

    private String computeParamName(String fieldName)
    {
        return fieldName + "AsJsonString";
    }

}
