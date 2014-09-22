package com.usesoft.highcharts4gwt.generator.codemodel.field;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;

public class InterfaceFieldHelper
{
    private InterfaceFieldHelper()
    {
    }

    public static void addGetterSetterDeclaration(String fieldName, Class<?> type, JDefinedClass jDefinedClass)
    {
        jDefinedClass.method(JMod.NONE, type, fieldName);

        jDefinedClass.method(JMod.NONE, jDefinedClass, fieldName).param(type, fieldName);
    }

    public static void addGetterSetterDeclaration(String fieldName, JClass type, JDefinedClass jDefinedClass)
    {
        jDefinedClass.method(JMod.NONE, type, fieldName);

        jDefinedClass.method(JMod.NONE, jDefinedClass, fieldName).param(type, fieldName);
    }
}
