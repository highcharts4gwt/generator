package com.github.highcharts4gwt.generator.object.klass;

import com.github.highcharts4gwt.generator.OutputType;
import com.google.gwt.core.client.JavaScriptObject;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;

public class ObjectJsoClassBuilder extends ConcreteObjectClassWriter
{

    public ObjectJsoClassBuilder(String rootDirectory)
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
        return OutputType.Jso.name();
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Jso;
    }
}
