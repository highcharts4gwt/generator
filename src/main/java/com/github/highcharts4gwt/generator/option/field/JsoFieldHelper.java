package com.github.highcharts4gwt.generator.option.field;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.NativeContentHack;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.option.Option;
import com.google.common.base.Strings;
import com.google.gwt.dom.client.NativeEvent;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;

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

    private static void writeGetterNativeCode(Names names, Class<?> type, JDefinedClass jDefinedClass, String getterCode)
    {
        NativeContentHack getterContentHack = new NativeContentHack(getterCode);
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, type, names.getGetterName())._throws(getterContentHack);
    }

    private static void writeGetterNativeCode(Names names, JClass type, JDefinedClass jDefinedClass, String getterCode)
    {
        NativeContentHack getterContentHack = new NativeContentHack(getterCode);
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, type, names.getGetterName())._throws(getterContentHack);
    }

    public static void writeGetterNativeCodeString(Names names, Class<?> type, JDefinedClass jDefinedClass, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForString(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeGetterNativeCodeStringWithStringify(Names names, Class<?> type, JDefinedClass jDefinedClass, String defaultValue)
    {
        String getterCode = getJsniGetterCodeWithStringify(names.getOriginalFieldName(), getJsniDefaultValueForJsonObject(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeGetterNativeCodeBoolean(Names names, Class<?> type, JDefinedClass jDefinedClass, boolean defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForBoolean(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeGetterNativeCodeNumber(Names names, Class<?> type, JDefinedClass jDefinedClass, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForNumber(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeGetterNativeCodeArrayString(Names names, Class<?> type, JDefinedClass jDefinedClass, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeGetterNativeCodeObject(Names names, JClass type, JDefinedClass jDefinedClass, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForObject(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeGetterNativeCodeArrayObject(Names names, JClass type, JDefinedClass jDefinedClass, String defaultValue)
    {
        String getterCode = getJsniGetterCode(names.getOriginalFieldName(), getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeGetterNativeCodeArrayJsonObject(Names names, Class<?> type, JDefinedClass jDefinedClass, String defaultValue)
    {
        String getterCode = getJsniGetterCodeWithStringify(names.getOriginalFieldName(), getJsniDefaultValueForArray(defaultValue));
        writeGetterNativeCode(names, type, jDefinedClass, getterCode);
    }

    public static void writeSetterNativeCode(Names names, Class<?> type, JDefinedClass jDefinedClass)
    {
        NativeContentHack setterContentHack = new NativeContentHack(JsoFieldHelper.getJsniSetterCode(names.getOriginalFieldName(), names.getParamName()));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, names.getSetterName())._throws(setterContentHack)
                .param(type, names.getParamName());
    }

    public static void writeSetterNativeCodeWithParse(Names names, Class<?> type, JDefinedClass jDefinedClass)
    {
        NativeContentHack setterContentHack = new NativeContentHack(JsoFieldHelper.getJsniSetterCodeWithParse(names.getOriginalFieldName(),
                names.getParamName()));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, names.getSetterName())._throws(setterContentHack)
                .param(type, names.getParamName());
    }

    public static void writeSetterNativeCode(Names names, JClass type, JDefinedClass jDefinedClass)
    {
        NativeContentHack setterContentHack = new NativeContentHack(JsoFieldHelper.getJsniSetterCode(names.getOriginalFieldName(), names.getParamName()));
        jDefinedClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jDefinedClass, names.getSetterName())._throws(setterContentHack)
                .param(type, names.getParamName());
    }

    public static String getJsniSeriesEventGetter()
    {
        return "/*-{\n        return this.source.chart.options.series[this.source.index];\n    }-*/";
    }

    public static String getContextObject()
    {
        return "/*-{\n        return this.source;\n    }-*/";
    }

    private static String getJsniEventHandler(String eventName, String handlerMethodName, String handlerClassFqn, String eventTypeFqn)
    {
        String paramName = "this";

        return "\n        " + "/*-{" + "\n            " + "$wnd.jQuery.extend(true, " + paramName + ", " + "\n            " + "{" + "\n                "
                + "events: {" + "\n                    " + eventName + ": function(event) {" + "\n                        " + "handler.@" + handlerClassFqn
                + "::" + handlerMethodName + "(L" + eventTypeFqn + ";)(" + "\n                            " + "$wnd.jQuery.extend(true, event, {source:this})"
                + "\n                         " + ");" + "\n                     " + "}" + "\n                 " + "}" + "\n             " + "});"
                + "\n        " + "}-*/;";
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

            // write getter for Series / Point or Chart inside event
            if (option.getContext() != null)
                EventHelper.getType(option).accept(new EventGetterWriterVisitor(option, jClass, model), OutputType.Jso);

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

    public static void addEventHandlerRegistrationMethods(Option option, JDefinedClass jClass)
    {
        List<JClass> list = EventRegistry.INSTANCE.getRegistry().get(option.getFullname());
        if (list != null)
        {
            for (JClass handlerClass : list)
            {
                String eventName = computeEventName(handlerClass);
                String handlerMethodName = computeHandlerMethodName(handlerClass);
                String eventFqn = computeEventFqn(handlerClass);
                String handlerClassName = handlerClass.name();
                String paramName = "handler";

                String jsniEventHandlerContent = getJsniEventHandler(eventName, handlerMethodName, handlerClass.fullName(), eventFqn);
                NativeContentHack addHandlerMethodContent = new NativeContentHack(jsniEventHandlerContent);

                jClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, void.class, EventHelper.ADD_HANDLER_METHOD_PREFIX + handlerClassName)
                        ._throws(addHandlerMethodContent).param(handlerClass, paramName);
            }
        }
    }

    private static String computeEventName(JClass handlerClass)
    {
        JMethod method = ((JDefinedClass) handlerClass).methods().iterator().next();
        String eventName = method.name().substring(2);
        eventName = eventName.substring(0, 1).toLowerCase() + eventName.substring(1);
        int iCap = firstIndexOfUcl(eventName);
        eventName = eventName.substring(iCap);
        eventName = eventName.substring(0, 1).toLowerCase() + eventName.substring(1);
        return eventName;
    }

    private static String computeEventFqn(JClass handlerClass)
    {
        JMethod method = ((JDefinedClass) handlerClass).methods().iterator().next();
        JVar param = method.params().iterator().next();
        String fullName = param.type().fullName();
        fullName = fullName.replace(".", "/");
        return fullName;
    }

    private static String computeHandlerMethodName(JClass handlerClass)
    {
        JMethod method = ((JDefinedClass) handlerClass).methods().iterator().next();
        String methodName = method.name();

        return methodName;
    }

    private static int firstIndexOfUcl(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isUpperCase(str.charAt(i)))
            {
                return i;
            }
        }
        return -1;
    }

    public static void addGenericJsonObjectGetterSetterDeclaration(JDefinedClass in)
    {
        String getterCode = "/*-{\n" + "        this[fieldName] = (this[fieldName] || {});\n"
        + "        return JSON.stringify(this[fieldName]);\n" + "    }-*/";
        
        NativeContentHack getterContentHack = new NativeContentHack(getterCode);
        JMethod getterMethod = in.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, String.class, "getFieldAsJsonObject");
        getterMethod.param(String.class, "fieldName");
        getterMethod._throws(getterContentHack);

        
        String setterCode = "/*-{\n" + "        this[fieldName] = JSON.parse(fieldValueAsJsonObject);\n" + "        return this;\n" + "    }-*/";
        
        NativeContentHack setterContentHack = new NativeContentHack(setterCode);
        JMethod setterMethod = in.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, in, "setFieldAsJsonObject");
        setterMethod._throws(setterContentHack);
        setterMethod.param(String.class, "fieldName");
        setterMethod.param(String.class, "fieldValueAsJsonObject");
        
    }

    public static void addFunctionGetterSetterDeclaration(JDefinedClass in)
    {
        String fieldNameParam = "fieldName";
        String functionAsStringParam = "functionAsString";
        String getFunctionAsStringMethodName = "getFunctionAsString";
        String setFunctionAsStringMethodName = "setFunctionAsString";

        String getterCode = "/*-{\n" + "        this["+fieldNameParam+"] = (this["+fieldNameParam+"] || {});\n"
        + "        return JSON.stringify(this["+fieldNameParam+"]);\n" + "    }-*/";
        
        NativeContentHack getterContentHack = new NativeContentHack(getterCode);
        JMethod getterMethod = in.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, String.class, getFunctionAsStringMethodName);
        getterMethod.param(String.class, fieldNameParam);
        getterMethod._throws(getterContentHack);

        
        String setterCode = "/*-{\n" + "        this["+fieldNameParam+"] = eval('(' + "+functionAsStringParam+" + ')');\n" + "        return this;\n" + "    }-*/";
        
        NativeContentHack setterContentHack = new NativeContentHack(setterCode);
        JMethod setterMethod = in.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, in, setFunctionAsStringMethodName);
        setterMethod._throws(setterContentHack);
        setterMethod.param(String.class, fieldNameParam);
        setterMethod.param(String.class, functionAsStringParam);
        
    }
}
