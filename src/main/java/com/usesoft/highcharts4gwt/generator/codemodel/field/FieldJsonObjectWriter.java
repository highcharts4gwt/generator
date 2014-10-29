package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;

public class FieldJsonObjectWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final String defaultValue;

    public FieldJsonObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), String.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        String paramName = computeParamName(fieldName);

        JsoFieldHelper.writeGetterNativeCodeStringWithStringify(fieldName, String.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCodeWithParse(fieldName, paramName, String.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        String paramName = computeParamName(fieldName);

        MockFieldHelper.addGetterSetterDeclaration(fieldName, paramName, paramName, String.class, getJclass());
        return null;
    }

    // TODO remove this
    private String computeParamName(String fieldName)
    {
        return fieldName + "AsJsonString";
    }

    @Override
    protected String getNameExtension()
    {
        return "AsJsonString";
    }

    @Override
    protected boolean isParamNameSpecial()
    {
        return true;
    }

}
