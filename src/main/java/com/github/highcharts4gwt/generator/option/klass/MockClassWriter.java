package com.github.highcharts4gwt.generator.option.klass;

import com.github.highcharts4gwt.generator.OutputType;
import com.sun.codemodel.JClassAlreadyExistsException;

public class MockClassWriter extends ConcreteClassWriter
{
    public MockClassWriter(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    public String getPrefix()
    {
        return OutputType.Mock.name();
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Mock;
    }

}
