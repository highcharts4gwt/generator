package com.usesoft.highcharts4gwt.generator.codemodel.field;

import java.io.File;
import java.io.IOException;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.google.gwt.dom.client.NativeEvent;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.klass.NativeContentHack;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class JsoFieldHelper
{
    private static final Logger logger = LoggerFactory.getLogger(JsoFieldHelper.class);

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

    private static String getJsniDefaultValueForNumber(@CheckForNull String defaultValueFromOption)
    {
        // TODO Report to HS - Strange cases with numbers - empty or undefined ?
        String out;
        if (defaultValueFromOption == null || defaultValueFromOption.equals("null"))
        {
            out = "null";
        }
        else if (defaultValueFromOption.equals("undefined"))
        {
            out = "undefined";
        }
        else if (defaultValueFromOption.equals(""))
        {
            out = "''";
        }
        else
        {
            try
            {
                out = Double.toString(Double.parseDouble(defaultValueFromOption));
            }
            catch (NumberFormatException e)
            {
                logger.error("Cannot parse default value as Number;" + defaultValueFromOption);
                out = "null";
            }

        }
        return out;
    }

    private static String getJsniDefaultValueForJsonObject(String defaultValue)
    {
        if (defaultValue == null)
            return "{}";
        return "JSON.parse('" + defaultValue + "')";
    }

    private static String getJsniDefaultValueForString(String defaultValue)
    {
        String value = defaultValue != null ? defaultValue.replace("\"", "\\\"") : defaultValue;
        return "\"" + value + "\"";
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

    private static void writeGetterNativeCode(Names names, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String getterCode)
    {
        NativeContentHack getterContentHack = new NativeContentHack(jCodeModel, getterCode);
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, type, names.getGetterName())._throws(getterContentHack);
    }

    private static void writeGetterNativeCode(Names names, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String getterCode)
    {
        NativeContentHack getterContentHack = new NativeContentHack(jCodeModel, getterCode);
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, type, names.getGetterName())._throws(getterContentHack);
    }

    public static void writeGetterNativeCodeString(Names names, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForString(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeStringWithStringify(Names names,
                    Class<?> type,
                    JDefinedClass jDefinedClass,
                    JCodeModel jCodeModel,
                    String defaultValue)
    {
        String getterCode = getJsniGetterCodeWithStringify(names.getOriginalFieldName(), getJsniDefaultValueForJsonObject(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeBoolean(Names names, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, boolean defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForBoolean(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeNumber(Names names, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForNumber(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeArrayString(Names names, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeObject(Names names, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForObject(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeArrayObject(Names names, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeGetterNativeCodeArrayJsonObject(Names names,
                    Class<?> type,
                    JDefinedClass jDefinedClass,
                    JCodeModel jCodeModel,
                    String defaultValue)
    {
        String getterCode = getJsniGetterCodeWithStringify(names.getOriginalFieldName(), getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, jCodeModel, getterCode);
    }

    public static void writeSetterNativeCode(Names names, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCode(names.getOriginalFieldName(),
                        names.getParamName()));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, names.getSetterName())._throws(setterContentHack)
                        .param(type, names.getParamName());
    }

    public static void writeSetterNativeCodeWithParse(Names names, Class<?> type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCodeWithParse(names.getOriginalFieldName(),
                        names.getParamName()));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, names.getSetterName())._throws(setterContentHack)
                        .param(type, names.getParamName());
    }

    public static void writeSetterNativeCode(Names names, JClass type, JDefinedClass jDefinedClass, JCodeModel jCodeModel)
    {
        NativeContentHack setterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSetterCode(names.getOriginalFieldName(),
                        names.getParamName()));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, names.getSetterName())._throws(setterContentHack)
                        .param(type, names.getParamName());
    }

    private static String getJsniSeriesEventGetter()
    {
        return "/*-{\n        return this.source.chart.options.series[this.source.index];\n    }-*/";
    }

    public static void createEventJso(Option option, String packageName, String rootDirectoryPathName)
    {
        JCodeModel model = new JCodeModel();

        try
        {
            JDefinedClass jClass = model._class(packageName + "." + OutputType.Jso.toString() + EventHelper.getEventNamePrefix(option)
                            + EventHelper.EVENT_SUFFIX, ClassType.CLASS);

            JClass eventClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));

            jClass._implements(eventClass);
            jClass._extends(NativeEvent.class);

            jClass.constructor(JMod.PROTECTED);

            createEventGetters(option, model, jClass);

            ClassRegistry.INSTANCE.put(option, OutputType.Jso, jClass);

        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            model.build(new File(rootDirectoryPathName));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    private static void createEventGetters(Option option, JCodeModel jCodeModel, JDefinedClass jDefinedClass)
    {
        if (EventHelper.getType(option.getFullname()) == EventType.Series)
        {
            NativeContentHack getterContentHack = new NativeContentHack(jCodeModel, getJsniSeriesEventGetter());
            JClass series = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(new Option("series", "", ""), OutputType.Interface));

            jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, series, EventHelper.GET_SERIES_METHOD_NAME)._throws(getterContentHack);
        }

    }
}
