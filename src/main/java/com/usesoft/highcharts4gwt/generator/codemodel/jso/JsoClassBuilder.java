package com.usesoft.highcharts4gwt.generator.codemodel.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.RealClassBuilder;

public class JsoClassBuilder extends RealClassBuilder
{
    private static final String CLASS_PREFIX = "Jso";
    private final FieldBuilder fieldBuilder;

    public JsoClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
        fieldBuilder = new JsoFieldBuilder();
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
    public FieldBuilder getFieldBuilder()
    {
        return fieldBuilder;
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Jso;
    }

}
