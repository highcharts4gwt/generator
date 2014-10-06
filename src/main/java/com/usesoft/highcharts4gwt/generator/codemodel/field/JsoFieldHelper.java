package com.usesoft.highcharts4gwt.generator.codemodel.field;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.klass.NativeContentHack;

public class JsoFieldHelper
{
    private JsoFieldHelper()
    {
    }

    private static String getJsniGetterCode(String fieldName, String jsniDefaultValue)
    {
        return "/*-{\n" + "        return this[\"" + fieldName + "\"] = (this[\"" + fieldName + "\"] || " + jsniDefaultValue + ");\n" + "    }-*/";
    }

    // TODO See how this could go to FieldType, in each type implem
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
        // TODO Report to HS - Number default value with null ?
        if (defaultValue == null)
            return "null";
        return Double.toString((Double) defaultValue);
    }

    private static String getJsniDefaultValueForArray(String defaultValue)
    {
        if (defaultValue == null)
            return "[]";
        return defaultValue;
    }

    private static String getJsniDefaultValueForObject(String defaultValue)
    {
        if (defaultValue == null)
            return "{}";
        return defaultValue;
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

    private static void writeGetterNativeCode(String fieldName, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String getterCode)
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

    public static void writeGetterNativeCodeArrayString(String fieldName,
                    Class<?> type,
                    JDefinedClass jDefinedClass,
                    JCodeModel jCodeModel,
                    String defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeObject(String fieldName, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForObject(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeArrayString(String fieldName, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeArrayObject(String fieldName, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeSetterNativeCode(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCode(fieldName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, fieldName);
    }

    public static void writeSetterNativeCode(String fieldName, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCode(fieldName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, fieldName);
    }
}
