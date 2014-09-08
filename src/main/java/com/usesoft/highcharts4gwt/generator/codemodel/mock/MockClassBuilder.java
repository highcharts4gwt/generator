package com.usesoft.highcharts4gwt.generator.codemodel.mock;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.RealClassBuilder;

public class MockClassBuilder extends RealClassBuilder
{
    private static final String CLASS_PREFIX = "Mock";
    private final FieldBuilder fieldBuilder;

    public MockClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
        fieldBuilder = new MockFieldBuilder();
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

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Mock;
    }

}
