package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.model.array.api.ArrayString;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayStringWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    private final String defaultValue;

    public FieldArrayStringWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName);
        this.defaultValue = option.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), ArrayString.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeArrayString(getNames(), ArrayString.class, getJclass(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), ArrayString.class, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterSetterDeclaration(getNames(), ArrayString.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsArrayString";
    }
}
