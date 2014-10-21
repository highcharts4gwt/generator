package com.usesoft.highcharts4gwt.generator.codemodel.field;

import com.google.common.base.Strings;
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

    // Getter
    private static String getJsniGetterCode(String fieldName, String jsniDefaultValue)
    {
        return "/*-{\n" + "        return this[\"" + fieldName + "\"] = (this[\"" + fieldName + "\"] || " + jsniDefaultValue + ");\n" + "    }-*/";
    }

    private static String getJsniGetterCodeWithStringify(String fieldName, String jsniDefaultValue)
    {
        return "/*-{\n" + "        this[\"" + fieldName + "\"] = (this[\"" + fieldName + "\"] || " + jsniDefaultValue + ");\n"
                        + "        return JSON.stringify(this[\"" + fieldName + "\"]);\n" + "    }-*/";
    }

    // Setter
    private static String getJsniSetterCode(String fieldName, String fieldValue)
    {
        return "/*-{\n" + "        this[\"" + fieldName + "\"] = " + fieldValue + ";\n" + "        return this;\n" + "    }-*/";
    }

    private static String getJsniSetterCodeWithParse(String fieldName, String paramName)
    {
        return "/*-{\n" + "        this[\"" + fieldName + "\"] = JSON.parse(" + paramName + ");\n" + "        return this;\n" + "    }-*/";
    }

    private static String getJsniDefaultValueForJsonObject(String defaultValue)
    {
        if (defaultValue == null)
            return "{}";
        return "JSON.parse('" + defaultValue + "')";
    }

    private static String getJsniDefaultValueForString(String defaultValue)
    {
        return "\"" + defaultValue + "\"";
    }

    private static String getJsniDefaultValueForBoolean(boolean defaultValue)
    {
        return Boolean.toString(defaultValue);
    }

    private static String getJsniDefaultValueForArray(String defaultValue)
    {
        if (Strings.isNullOrEmpty(defaultValue))
            return "[]";
        return defaultValue;
    }

    private static String getJsniDefaultValueForObject(String defaultValue)
    {
        if (Strings.isNullOrEmpty(defaultValue))
            return "{}";
        return defaultValue;
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

    public static void writeGetterNativeCodeStringWithStringify(String fieldName,
                    Class<?> type,
                    JDefinedClass jDefinedClass,
                    JCodeModel jCodeModel,
                    String defaultValue)
    {
        String getterCode = getJsniGetterCodeWithStringify(fieldName, getJsniDefaultValueForJsonObject(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeBoolean(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, boolean defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, getJsniDefaultValueForBoolean(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeNumber(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(fieldName, defaultValue);
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

    public static void writeGetterNativeCodeArrayJsonObject(String fieldName,
                    Class<?> type,
                    JDefinedClass jDefinedClass,
                    JCodeModel jCodeModel,
                    String defaultValue)
    {
        String getterCode = getJsniGetterCodeWithStringify(fieldName, getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(fieldName, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeSetterNativeCode(String fieldName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCode(fieldName, fieldName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, fieldName);
    }

    public static void writeSetterNativeCodeWithParse(String fieldName, String paramName, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCodeWithParse(fieldName, paramName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, paramName);
    }

    public static void writeSetterNativeCodeWithParse(String fieldName, String paramName, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCodeWithParse(fieldName, paramName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, paramName);
    }

    public static void writeSetterNativeCode(String fieldName, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCode(fieldName, fieldName));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, fieldName)._throws(setterContentHack).param(type, fieldName);
    }
}
