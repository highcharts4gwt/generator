package com.usesoft.highcharts4gwt.generator.codemodel.jso;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseClassBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;

public class JsoClassBuilder extends BaseClassBuilder
{
    private static final String CLASS_PREFIX = "Jso";
    private FieldBuilder fieldBuilder;

    public JsoClassBuilder(String rootDirectory)
            throws JClassAlreadyExistsException
    {
        super(rootDirectory);
        fieldBuilder = new JsoFieldBuilder();
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
