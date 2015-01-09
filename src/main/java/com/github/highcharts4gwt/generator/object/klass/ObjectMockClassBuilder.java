package com.github.highcharts4gwt.generator.object.klass;

import com.github.highcharts4gwt.generator.OutputType;

public class ObjectMockClassBuilder extends ConcreteObjectClassWriter
{

    public ObjectMockClassBuilder(String rootDirectory)
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
