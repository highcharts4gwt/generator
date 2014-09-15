package com.usesoft.highcharts4gwt.generator.codemodel.api;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseFieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;

public class InterfaceFieldBuilder extends BaseFieldBuilder implements FieldBuilder
{

    // @Override
    // protected void addNumberField(String fieldName)
    // {
    // getJclass().method(JMod.NONE, Number.class, fieldName);
    //
    // getJclass().method(JMod.NONE, getJclass(), fieldName).param(Number.class,
    // fieldName);
    // }
    //
    // @Override
    // protected void addStringField(String fieldName)
    // {
    // getJclass().method(JMod.NONE, String.class, fieldName);
    //
    // getJclass().method(JMod.NONE, getJclass(), fieldName).param(String.class,
    // fieldName);
    //
    // }
    //
    // @Override
    // protected void addBooleanField(String fieldName)
    // {
    // getJclass().method(JMod.NONE, boolean.class, fieldName);
    //
    // getJclass().method(JMod.NONE, getJclass(),
    // fieldName).param(boolean.class, fieldName);
    // }

    @Override
    protected void addObjectField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void addFunctionField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void addColorField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void addMixedField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void addCssObjectField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void addClassField(JClass jClass, String fieldName)
    {
        getJclass().method(JMod.NONE, jClass, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(jClass, fieldName);
    }

    @Override
    protected void addStringArray(String fieldName)
    {
        getJclass().method(JMod.NONE, ArrayString.class, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(ArrayString.class, fieldName);
    }

    @Override
    protected void addNumberArray(String fieldName)
    {
        getJclass().method(JMod.NONE, ArrayNumber.class, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(ArrayNumber.class, fieldName);
    }

    @Override
    protected void addObjectArray(JClass jClass, String fieldName)
    {
        JClass detailClass = jClass;
        JClass rawLLclazz = getCodeModel().ref(Array.class);
        JClass fieldClazz = rawLLclazz.narrow(detailClass);

        getJclass().method(JMod.NONE, fieldClazz, fieldName);

        getJclass().method(JMod.NONE, getJclass(), fieldName).param(fieldClazz, fieldName);
    }

    @Override
    protected OutputType getOutputType()
    {
        return OutputType.Interface;
    }

}
