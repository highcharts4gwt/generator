package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JDefinedClass;

public class FieldBooleanWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final boolean defaultValue;

    public FieldBooleanWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName, option.getDescription());
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
        JsoFieldHelper.writeGetterNativeCodeBoolean(getNames(), boolean.class, getJclass(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), boolean.class, getJclass());
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
