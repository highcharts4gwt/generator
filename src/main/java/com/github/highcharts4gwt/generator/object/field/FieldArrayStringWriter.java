package com.github.highcharts4gwt.generator.object.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.field.AbstractFieldWriter;
import com.github.highcharts4gwt.generator.option.field.InterfaceFieldHelper;
import com.github.highcharts4gwt.generator.option.field.JsoFieldHelper;
import com.github.highcharts4gwt.generator.option.field.MockFieldHelper;
import com.github.highcharts4gwt.model.array.api.ArrayString;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayStringWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    public FieldArrayStringWriter(JDefinedClass jClass, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName);
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterDeclaration(getNames(), ArrayString.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeArrayString(getNames(), ArrayString.class, getJclass(), null);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterDeclaration(getNames(), ArrayString.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsArrayString";
    }
}
