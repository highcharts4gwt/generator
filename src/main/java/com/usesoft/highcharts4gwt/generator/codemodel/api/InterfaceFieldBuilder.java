package com.usesoft.highcharts4gwt.generator.codemodel.api;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseFieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;

public class InterfaceFieldBuilder extends BaseFieldBuilder implements FieldBuilder
{

    @Override
    public void addNumberField(String fieldName)
    {
        getJclass().method(JMod.NONE, Number.class, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(Number.class, fieldName);
    }

    @Override
    public void addStringField(String fieldName)
    {
        getJclass().method(JMod.NONE, String.class, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(String.class, fieldName);

    }

    @Override
    public void addBooleanField(String fieldName)
    {
        getJclass().method(JMod.NONE, boolean.class, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(boolean.class, fieldName);
    }

    @Override
    public void addObjectField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFunctionField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addColorField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addMixedField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addCssObjectField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addClassField(JClass jClass, String fieldName)
    {
        getJclass().method(JMod.NONE, jClass, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(jClass, fieldName);
    }

    @Override
    protected OutputType getOutputType()
    {
        return OutputType.Interface;
    }

}
