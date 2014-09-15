package com.usesoft.highcharts4gwt.generator.codemodel.field;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.jso.NativeContentHack;

public class JsoFieldHelper
{
    private JsoFieldHelper()
    {
    }

    public static String getGetterForObjectContent(String fieldName)
    {
        return "/*-{\n" + "        return this[\"" + fieldName + "\"] = (this[\"" + fieldName + "\"] || {});\n" + "    }-*/";
    }

    public static String getGetterForArrayContent(String fieldName)
    {
        return "/*-{\n" + "        return this[\"" + fieldName + "\"] = (this[\"" + fieldName + "\"] || []);\n" + "    }-*/";
    }

    public static String getSetterContent(String fieldName)
    {
        return "/*-{\n" + "        this[\"" + fieldName + "\"] = " + fieldName + ";\n" + "        return this;\n" + "    }-*/";
    }

    // TODO This always return an object, should return boolean / String value /
    // Number value based on default value
    public static void addGetterSetterDeclaration(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack getterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getGetterForObjectContent(fieldName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, type, fieldName)._throws(getterContentHack);

        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getSetterContent(fieldName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, fieldName);
    }
}
