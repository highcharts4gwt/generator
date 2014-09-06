package com.usesoft.highcharts4gwt.generator.codemodel.api;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseClassBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;

public class InterfaceClassBuilder extends BaseClassBuilder
{
    private static final String CLASS_PREFIX = "api";
    private FieldBuilder fieldBuilder;

    public InterfaceClassBuilder(String rootDirectory)
            throws JClassAlreadyExistsException
    {
        super(rootDirectory);
        fieldBuilder = new InterfaceFieldBuilder();
    }

    @Override
    public String getPrefix()
    {
        return CLASS_PREFIX;
    }

    @Override
    public FieldBuilder getFieldBuilder()
    {
        return fieldBuilder;
    }

}
