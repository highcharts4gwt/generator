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

    public static void addGetterSetterDeclaration(String fieldName, Class<?> type, JDefinedClass jDefinedClass)
    {
        JFieldVar field = jDefinedClass.field(JMod.PRIVATE, type, fieldName);

        JMethod getter = jDefinedClass.method(JMod.PUBLIC, type, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = jDefinedClass.method(JMod.PUBLIC, jDefinedClass, fieldName);
        JVar setterParam = setter.param(type, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    public static void addGetterSetterDeclaration(String fieldName, JClass type, JDefinedClass jDefinedClass)
    {
        JFieldVar field = jDefinedClass.field(JMod.PRIVATE, type, fieldName);

        JMethod getter = jDefinedClass.method(JMod.PUBLIC, type, fieldName);
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = jDefinedClass.method(JMod.PUBLIC, jDefinedClass, fieldName);
        JVar setterParam = setter.param(type, fieldName);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }
}
