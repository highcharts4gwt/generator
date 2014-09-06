package com.usesoft.highcharts4gwt.generator.codemodel.mock;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseClassBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;

public class MockClassBuilder extends BaseClassBuilder
{
    private static final String CLASS_PREFIX = "Mock";
    private FieldBuilder fieldBuilder;

    public MockClassBuilder(String rootDirectory)
            throws JClassAlreadyExistsException
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

}
