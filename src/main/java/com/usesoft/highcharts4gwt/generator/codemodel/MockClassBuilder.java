package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JClassAlreadyExistsException;

public class MockClassBuilder extends BaseClassBuilder
{

    public MockClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    public String getPrefix()
    {
        return "Mock";
    }

}
