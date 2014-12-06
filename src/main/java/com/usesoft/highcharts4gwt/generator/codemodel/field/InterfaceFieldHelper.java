package com.usesoft.highcharts4gwt.generator.codemodel.field;

import java.io.File;
import java.io.IOException;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class InterfaceFieldHelper
{
    private static final String HANDLER_SUFFIX = "Handler";
    private static final String EVENT_SUFFIX = "Event";
    private static final String ON_PREFIX = "on";

    private InterfaceFieldHelper()
    {
    }

    public static void addGetterSetterDeclaration(Names names, Class<?> type, JDefinedClass jDefinedClass)
    {
        jDefinedClass.method(JMod.NONE, type, names.getGetterName());

        jDefinedClass.method(JMod.NONE, jDefinedClass, names.getSetterName()).param(type, names.getParamName());
    }

    public static void addGetterSetterDeclaration(Names names, JClass type, JDefinedClass jDefinedClass)
    {
        jDefinedClass.method(JMod.NONE, type, names.getGetterName());

        jDefinedClass.method(JMod.NONE, jDefinedClass, names.getSetterName()).param(type, names.getParamName());
    }

    public static void createEventInterface(Option option, String packageName, String rootDirectoryPathName)
    {
        JCodeModel model = new JCodeModel();

        try
        {
            JDefinedClass jClass = model._class(packageName + "." + getEventNamePrefix(option) + EVENT_SUFFIX, ClassType.INTERFACE);
            ClassRegistry.INSTANCE.put(option, OutputType.Interface, jClass);
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

    public static String getEventNamePrefix(Option option)
    {
        // plotOptions.gauge.events.afterAnimate
        String fullname = option.getFullname();

        int i = fullname.indexOf(".events");

        // plotOptions.gauge
        String v1 = fullname.substring(0, i);

        // gauge
        int i2 = v1.lastIndexOf(".");
        String v2 = "";
        if (i2 != -1)
        {
            v2 = v1.substring(i2 + 1, v1.length());
            v2 = v2.substring(0, 1).toUpperCase() + v2.substring(1);
        }
        else
        {
            v2 = v1.substring(0, 1).toUpperCase() + v1.substring(1);
        }

        // GaugeClickEvent
        String eventName = v2 + option.getTitle().substring(0, 1).toUpperCase() + option.getTitle().substring(1);
        return eventName;
    }

    public static void createEventHandlerInterface(Option option, String packageName, String rootDirectoryPathName)
    {
        JCodeModel model = new JCodeModel();

        try
        {
            String eventName = getEventNamePrefix(option);
            String fullyqualifiedName = packageName + "." + eventName + HANDLER_SUFFIX;
            JDefinedClass jClass = model._class(fullyqualifiedName, ClassType.INTERFACE);

            JClass eventClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));

            jClass.method(JMod.NONE, void.class, ON_PREFIX + eventName).param(eventClass, paramName(eventName));

            ClassRegistry.INSTANCE.put(option, OutputType.Interface, jClass);
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

    private static String paramName(String eventName)
    {
        return eventName.substring(0, 1).toLowerCase() + eventName.substring(1) + EVENT_SUFFIX;
    }
}
