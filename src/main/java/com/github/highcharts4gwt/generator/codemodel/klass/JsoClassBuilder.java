package com.github.highcharts4gwt.generator.codemodel.klass;

import com.github.highcharts4gwt.generator.codemodel.OutputType;
import com.github.highcharts4gwt.generator.codemodel.RealClassBuilder;
import com.google.gwt.core.client.JavaScriptObject;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;

public class JsoClassBuilder extends RealClassBuilder
{
    private static final String CLASS_PREFIX = "Jso";

    public JsoClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    protected JDefinedClass declareType(String packageName, String className) throws JClassAlreadyExistsException
    {
        JDefinedClass jClass = getCodeModel()._class(packageName + "." + getPrefix() + className, getClassType())._implements(getInterface())
                ._extends(JavaScriptObject.class);
        jClass.constructor(JMod.PROTECTED);
        return jClass;
    }

    @Override
    public String getPrefix()
    {
        return CLASS_PREFIX;
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Jso;
    }

}
