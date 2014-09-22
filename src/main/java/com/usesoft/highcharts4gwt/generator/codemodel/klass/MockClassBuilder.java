package com.usesoft.highcharts4gwt.generator.codemodel.klass;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.RealClassBuilder;

public class MockClassBuilder extends RealClassBuilder
{
    private static final String CLASS_PREFIX = "Mock";

    public MockClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    public String getPrefix()
    {
        return CLASS_PREFIX;
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Mock;
    }

}
