package com.github.highcharts4gwt.generator.option.klass;

import com.github.highcharts4gwt.generator.common.OutputType;
import com.google.gwt.core.client.JavaScriptObject;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;

public class JsoClassWriter extends ConcreteClassWriter
{
    private static final String CLASS_PREFIX = "Jso";

    public JsoClassWriter(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    protected JDefinedClass createJClass() throws JClassAlreadyExistsException
    {
        JDefinedClass jClass = getCodeModel()._class(getFullyQualifiedName(), getClassType())._implements(getInterface())._extends(JavaScriptObject.class);
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
