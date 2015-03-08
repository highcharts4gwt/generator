package com.github.highcharts4gwt.generator.object.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.object.Object;
import com.github.highcharts4gwt.generator.option.field.AbstractFieldWriter;
import com.github.highcharts4gwt.generator.option.field.InterfaceFieldHelper;
import com.github.highcharts4gwt.generator.option.field.JsoFieldHelper;
import com.github.highcharts4gwt.generator.option.field.MockFieldHelper;
import com.sun.codemodel.JDefinedClass;

public class FieldNumberWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{

    public FieldNumberWriter(JDefinedClass jClass, boolean pipe, String fieldName, Object object)
    {
        super(jClass, pipe, fieldName, object.getDescription());
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterDeclaration(getNames(), double.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeNumber(getNames(), double.class, getJclass(), null);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterDeclaration(getNames(), double.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsNumber";
    }

}
