package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JDefinedClass;

public class FieldNumberWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    private final String defaultValue;

    public FieldNumberWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName, option.getDescription());
        this.defaultValue = option.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), double.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeNumber(getNames(), double.class, getJclass(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), double.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterSetterDeclaration(getNames(), double.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsNumber";
    }

}
