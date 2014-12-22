package com.github.highcharts4gwt.generator.codemodel.klass;

import com.github.highcharts4gwt.generator.codemodel.OutputType;
import com.github.highcharts4gwt.generator.codemodel.RealClassBuilder;
import com.sun.codemodel.JClassAlreadyExistsException;

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
