package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JClassAlreadyExistsException;

public class InterfaceClassBuilder extends BaseClassBuilder
{

    public InterfaceClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    public String getPrefix()
    {
        return "";
    }

}
