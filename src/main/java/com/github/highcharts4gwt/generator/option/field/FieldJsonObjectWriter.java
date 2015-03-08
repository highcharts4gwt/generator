package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JDefinedClass;

public class FieldJsonObjectWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final String defaultValue;
    private Option option;
    private final String fullName;

    public FieldJsonObjectWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName, option.getDescription());
        this.option = option;
        this.fullName = option.getFullname();
        this.defaultValue = option.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        if (fullName.endsWith("events"))
        {
            InterfaceFieldHelper.addEventHandlerRegistrationMethods(option, getJclass());
        }
        else
        {
            InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), String.class, getJclass());
        }
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        //TODO need to handle the weird case of the plotbands & plotline cases
        if (!fullName.endsWith("events"))
        {
            JsoFieldHelper.writeGetterNativeCodeStringWithStringify(getNames(), String.class, getJclass(), defaultValue);
            JsoFieldHelper.writeSetterNativeCodeWithParse(getNames(), String.class, getJclass());
        }
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        if (!fullName.endsWith("events"))
        {
            MockFieldHelper.addGetterSetterDeclaration(getNames(), String.class, getJclass());
        }
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsJsonString";
    }

    @Override
    protected boolean isParamNameSpecial()
    {
        return true;
    }

}
