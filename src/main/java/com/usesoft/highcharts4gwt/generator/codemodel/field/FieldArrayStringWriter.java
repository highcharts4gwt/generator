package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;

public class FieldArrayStringWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{
    private final String defaultValue;

    public FieldArrayStringWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), ArrayString.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeArrayString(fieldName, ArrayString.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, ArrayString.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterSetterDeclaration(fieldName, computeFieldName(fieldName), fieldName, ArrayString.class, getJclass());
        return null;
    }

    private String computeFieldName(String fieldName)
    {
        return fieldName + "AsArrayString";
    }

    @Override
    protected String getNameExtension()
    {
        return "AsArrayString";
    }
}
