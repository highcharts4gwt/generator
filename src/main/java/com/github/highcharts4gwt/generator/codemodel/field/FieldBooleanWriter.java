package com.github.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.graph.Option;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldBooleanWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final boolean defaultValue;

    public FieldBooleanWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.defaultValue = Boolean.parseBoolean(option.getDefaults());
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), boolean.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeBoolean(getNames(), boolean.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), boolean.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterSetterDeclaration(getNames(), boolean.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsBoolean";
    }

}
