package com.usesoft.highcharts4gwt.generator.codemodel.field;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;

public class MockFieldHelper
{
    private MockFieldHelper()
    {
    }

    public static void addGetterSetterDeclaration(Names names, Class<?> type, JDefinedClass jDefinedClass)
    {
        JFieldVar field = jDefinedClass.field(JMod.PRIVATE, type, names.getFieldName());

        JMethod getter = jDefinedClass.method(JMod.PUBLIC, type, names.getGetterName());
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = jDefinedClass.method(JMod.PUBLIC, jDefinedClass, names.getSetterName());
        JVar setterParam = setter.param(type, names.getParamName());

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    public static void addGetterSetterDeclaration(Names names, JClass type, JDefinedClass jDefinedClass)
    {
        JFieldVar field = jDefinedClass.field(JMod.PRIVATE, type, names.getFieldName());

        JMethod getter = jDefinedClass.method(JMod.PUBLIC, type, names.getFieldName());
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = jDefinedClass.method(JMod.PUBLIC, jDefinedClass, names.getFieldName());
        JVar setterParam = setter.param(type, names.getParamName());

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }
}
