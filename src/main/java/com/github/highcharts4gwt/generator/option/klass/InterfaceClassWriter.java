package com.github.highcharts4gwt.generator.option.klass;

import com.github.highcharts4gwt.generator.common.OutputType;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public class InterfaceClassWriter extends BaseClassWriter
{
    // private static final String CLASS_PREFIX = "api";

    public InterfaceClassWriter(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    public String getPrefix()
    {
        return "";
    }

    @Override
    protected JDefinedClass createJClass() throws JClassAlreadyExistsException
    {
        String fullyqualifiedName = getPackageName() + "." + getPrefix() + getShortClassName();
        return getCodeModel()._class(fullyqualifiedName, getClassType());
    }

    @Override
    protected ClassType getClassType()
    {
        return ClassType.INTERFACE;
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Interface;
    }

}
