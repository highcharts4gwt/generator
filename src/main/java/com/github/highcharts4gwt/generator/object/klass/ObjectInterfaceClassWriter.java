package com.github.highcharts4gwt.generator.object.klass;

import com.github.highcharts4gwt.generator.OutputType;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public class ObjectInterfaceClassWriter extends BaseObjectClassWriter
{

    public ObjectInterfaceClassWriter(String rootDirectory)
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
