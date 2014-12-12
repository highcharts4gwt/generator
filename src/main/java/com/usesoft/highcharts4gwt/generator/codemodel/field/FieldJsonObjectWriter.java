package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldJsonObjectWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final String defaultValue;
    private Option option;
    private final String fullName;

    public FieldJsonObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
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
        if (fullName.endsWith("events"))
        {

        }
        else
        {
            JsoFieldHelper.writeGetterNativeCodeStringWithStringify(getNames(), String.class, getJclass(), getCodeModel(), defaultValue);
            JsoFieldHelper.writeSetterNativeCodeWithParse(getNames(), String.class, getJclass(), getCodeModel());
        }
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        if (fullName.endsWith("events"))
        {

        }
        else
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
