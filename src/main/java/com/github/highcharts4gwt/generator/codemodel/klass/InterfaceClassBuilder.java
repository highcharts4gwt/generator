package com.github.highcharts4gwt.generator.codemodel.klass;

import com.github.highcharts4gwt.generator.codemodel.BaseClassWriter;
import com.github.highcharts4gwt.generator.codemodel.OutputType;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public class InterfaceClassBuilder extends BaseClassWriter
{
    // private static final String CLASS_PREFIX = "api";

    public InterfaceClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    public String getPrefix()
    {
        return "";
    }

    @Override
    protected JDefinedClass declareType(String packageName, String className) throws JClassAlreadyExistsException
    {
        return getCodeModel()._class(packageName + "." + getPrefix() + className, getClassType());
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
