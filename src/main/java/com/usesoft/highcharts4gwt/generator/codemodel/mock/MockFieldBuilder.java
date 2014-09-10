package com.usesoft.highcharts4gwt.generator.codemodel.mock;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseFieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;

public class MockFieldBuilder extends BaseFieldBuilder implements FieldBuilder
{

    @Override
    protected void addNumberField(String fieldName)
    {
        JFieldVar field = getJclass().field(JMod.PRIVATE, Number.class, fieldName);

        JMethod getter = getJclass().method(JMod.PUBLIC, Number.class, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = getJclass().method(JMod.PUBLIC, getJclass(), fieldName);
        JVar setterParam = setter.param(Number.class, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    @Override
    protected void addStringField(String fieldName)
    {
        JFieldVar field = getJclass().field(JMod.PRIVATE, String.class, fieldName);

        JMethod getter = getJclass().method(JMod.PUBLIC, String.class, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = getJclass().method(JMod.PUBLIC, getJclass(), fieldName);
        JVar setterParam = setter.param(String.class, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());

    }

    @Override
    protected void addBooleanField(String fieldName)
    {
        JFieldVar field = getJclass().field(JMod.PRIVATE, boolean.class, fieldName);

        JMethod getter = getJclass().method(JMod.PUBLIC, boolean.class, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = getJclass().method(JMod.PUBLIC, getJclass(), fieldName);
        JVar setterParam = setter.param(boolean.class, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

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
        JFieldVar field = getJclass().field(JMod.PRIVATE, jClass, fieldName);

        JMethod getter = getJclass().method(JMod.PUBLIC, jClass, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = getJclass().method(JMod.PUBLIC, getJclass(), fieldName);
        JVar setterParam = setter.param(jClass, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());

    }

    @Override
    protected void addStringArray(String fieldName)
    {
        JFieldVar field = getJclass().field(JMod.PRIVATE, ArrayString.class, fieldName);

        JMethod getter = getJclass().method(JMod.PUBLIC, ArrayString.class, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = getJclass().method(JMod.PUBLIC, getJclass(), fieldName);
        JVar setterParam = setter.param(ArrayString.class, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    @Override
    protected void addNumberArray(String fieldName)
    {
        JFieldVar field = getJclass().field(JMod.PRIVATE, ArrayNumber.class, fieldName);

        JMethod getter = getJclass().method(JMod.PUBLIC, ArrayNumber.class, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = getJclass().method(JMod.PUBLIC, getJclass(), fieldName);
        JVar setterParam = setter.param(ArrayNumber.class, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    @Override
    protected void addObjectArray(JClass jClass, String fieldName)
    {
        // JClass detailClass = jClass;
        // JClass rawLLclazz = getCodeModel().ref(Array.class);
        // JClass fieldClazz = rawLLclazz.narrow(detailClass);
        //
        // JFieldVar field = getJclass().field(JMod.PRIVATE, fieldClazz, fieldName);
        //
        // JMethod getter = getJclass().method(JMod.PUBLIC, fieldClazz, fieldName);
        // JBlock block = getter.body();
        // block._return(field);
        //
        // JMethod setter = getJclass().method(JMod.PUBLIC, getJclass(), fieldName);
        // JVar setterParam = setter.param(fieldClazz, fieldName);
        //
        // setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    @Override
    protected OutputType getOutputType()
    {
        return OutputType.Mock;
    }

}
