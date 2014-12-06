package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;

public class FieldArrayNumberWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{
    private final String defaultValue;

    public FieldArrayNumberWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.defaultValue = option.getDefaults();
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
        // Same code as ArrayString
        JsoFieldHelper.writeGetterNativeCodeArrayString(getNames(), ArrayNumber.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), ArrayNumber.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterSetterDeclaration(getNames(), ArrayNumber.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsArrayNumber";
    }

}
