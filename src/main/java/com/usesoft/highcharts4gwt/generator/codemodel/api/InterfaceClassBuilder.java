package com.usesoft.highcharts4gwt.generator.codemodel.api;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseClassBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;

public class InterfaceClassBuilder extends BaseClassBuilder
{
    // private static final String CLASS_PREFIX = "api";
    private final FieldBuilder fieldBuilder;

    public InterfaceClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
        fieldBuilder = new InterfaceFieldBuilder();
    }

    @Override
    public String getPrefix()
    {
        return "";
    }

    @Override
    public FieldBuilder getFieldBuilder()
    {
        return fieldBuilder;
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

}
