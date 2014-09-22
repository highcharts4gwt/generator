package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.model.array.api.Array;

public class FieldArrayObjectWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{
    private final String defaultValue;

    public FieldArrayObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue)
    {
        super(codeModel, className, jClass);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        JClass fieldClazz = getRealClass();

        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, fieldClazz, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        JClass fieldClazz = getRealClass();

        JsoFieldHelper.writeGetterNativeCodeArrayString(fieldName, fieldClazz, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, fieldClazz, getJclass(), getCodeModel());
        return null;
    }

    private JClass getRealClass()
    {
        JClass detailClass = getJclass();
        JClass rawLLclazz = getCodeModel().ref(Array.class);
        JClass fieldClazz = rawLLclazz.narrow(detailClass);
        return fieldClazz;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        JClass fieldClazz = getRealClass();

        MockFieldHelper.addGetterSetterDeclaration(fieldName, fieldClazz, getJclass());
        return null;
    }

}
