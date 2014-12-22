package com.github.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.graph.Option;
import com.github.highcharts4gwt.model.array.api.ArrayString;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayStringWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{
    private final String defaultValue;

    public FieldArrayStringWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
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
        JsoFieldHelper.writeGetterNativeCodeArrayString(getNames(), ArrayString.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), ArrayString.class, getJclass(), getCodeModel());
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
