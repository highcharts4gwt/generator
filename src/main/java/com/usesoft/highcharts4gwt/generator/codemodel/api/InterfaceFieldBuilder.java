package com.usesoft.highcharts4gwt.generator.codemodel.api;

import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseFieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;

public class InterfaceFieldBuilder extends BaseFieldBuilder implements FieldBuilder
{

    @Override
    public void addNumberField(String fieldName)
    {
        getJclass().method(JMod.PUBLIC, Number.class, fieldName);

        getJclass().method(JMod.PUBLIC, void.class, fieldName).param(Number.class, fieldName);
    }

    @Override
    public void addStringField(String fieldName)
    {
        getJclass().method(JMod.PUBLIC, String.class, fieldName);

        getJclass().method(JMod.PUBLIC, void.class, fieldName).param(String.class, fieldName);

    }

    @Override
    public void addBooleanField(String fieldName)
    {
        getJclass().method(JMod.PUBLIC, boolean.class, fieldName);

        getJclass().method(JMod.PUBLIC, void.class, fieldName).param(boolean.class, fieldName);
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
    public void addClassField(String className, String fieldName)
    {
        // TODO Auto-generated method stub

    }

}
