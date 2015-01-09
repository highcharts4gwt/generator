package com.github.highcharts4gwt.generator.object.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.field.AbstractFieldWriter;
import com.github.highcharts4gwt.generator.option.field.InterfaceFieldHelper;
import com.github.highcharts4gwt.generator.option.field.JsoFieldHelper;
import com.github.highcharts4gwt.generator.option.field.MockFieldHelper;
import com.sun.codemodel.JDefinedClass;

public class FieldStringWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    public FieldStringWriter(JDefinedClass jClass, com.github.highcharts4gwt.generator.object.Object option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName);
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterDeclaration(getNames(), String.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeString(getNames(), String.class, getJclass(), null);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterDeclaration(getNames(), String.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsString";
    }

}
