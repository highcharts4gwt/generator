package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;

public class FieldDataWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final String defaultValue;

    public FieldDataWriter(JCodeModel codeModel, JDefinedClass jClass, String className, String defaultValue, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.defaultValue = defaultValue;
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {

        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), ArrayNumber.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeArrayString(fieldName, ArrayNumber.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, ArrayNumber.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterSetterDeclaration(fieldName, fieldName, fieldName, ArrayNumber.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsData";
    }

}
