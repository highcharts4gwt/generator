package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;

public class FieldNumberWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{
    private final String defaultValue;

    public FieldNumberWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue, boolean pipe)
    {
        super(codeModel, className, jClass, pipe);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
       blabla do the same for all
        if (hasPipe())
            InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, computeFieldName(fieldName), Number.class, getJclass());
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
        MockFieldHelper.addGetterSetterDeclaration(fieldName, computeFieldName(fieldName), fieldName, Number.class, getJclass());
        return null;
    }

    private String computeFieldName(String fieldName)
    {
        return fieldName + "AsNumber";
    }

}
