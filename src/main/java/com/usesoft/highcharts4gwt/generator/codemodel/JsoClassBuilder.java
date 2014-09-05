package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JClassAlreadyExistsException;

public class JsoClassBuilder extends BaseClassBuilder
{

    public JsoClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    private static final String JSO_PREFIX = "Jso";

    @Override
    public String getPrefix()
    {
        return JSO_PREFIX;
    }
}
