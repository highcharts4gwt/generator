package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;

public class FieldArrayNumberWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{
    private final String defaultValue;

    public FieldArrayNumberWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue)
    {
        super(codeModel, className, jClass);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, ArrayNumber.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        // Same code as ArrayString
        JsoFieldHelper.writeGetterNativeCodeArrayString(fieldName, ArrayNumber.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, ArrayNumber.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        MockFieldHelper.addGetterSetterDeclaration(fieldName, fieldName, ArrayNumber.class, getJclass());
        return null;
    }

}
