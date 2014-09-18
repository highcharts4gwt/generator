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

    private static String getJsniGetterCode(String fieldName, String jsniDefaultValue)
    {
        return "/*-{\n" + "        return this[\"" + fieldName + "\"] = (this[\"" + fieldName + "\"] || " + jsniDefaultValue + ");\n" + "    }-*/";
    }

    private static String getJsniDefaultValueForString(String defaultValue)
    {
        return "\"" + defaultValue + "\"";
    }

    private static String getJsniDefaultValueForBoolean(boolean defaultValue)
    {
        return Boolean.toString(defaultValue);
    }

    private static String getJsniDefaultValueForNumber(Number defaultValue)
    {
        if (defaultValue == null)
            return "null";
        return Double.toString((Double) defaultValue);
    }

    private static String getJsniDefaultValueForObject()
    {
        return "{}";
    }

    private static String getJsniDefaultValueForArray()
    {
        return "[]";
    }

    private static String getJsniSetterCode(String fieldName)
    {
        return "/*-{\n" + "        this[\"" + fieldName + "\"] = " + fieldName + ";\n" + "        return this;\n" + "    }-*/";
    }

    private static void writeGetterNativeCode(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String getterCode)
    {
        NativeContentHack getterContentHack = new NativeContentHack(jCodeModel, getterCode);
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, type, fieldName)._throws(getterContentHack);
    }

    public static void writeGetterNativeCodeString(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForString(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeBoolean(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, boolean defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForBoolean(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeNumber(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, Number defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForNumber(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeObject(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForObject());
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeArray(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForArray());
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeSetterNativeCode(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCode(fieldName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, fieldName);
    }
}
