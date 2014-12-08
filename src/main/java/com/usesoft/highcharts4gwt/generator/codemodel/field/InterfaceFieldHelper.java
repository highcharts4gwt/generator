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
import com.usesoft.highcharts4gwt.model.event.NativeEvent;

public class InterfaceFieldHelper
{

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
            JDefinedClass jClass = model._class(packageName + "." + EventHelper.getEventNamePrefix(option) + EventHelper.EVENT_SUFFIX, ClassType.INTERFACE);
            // jClass._extends(NativeEvent.class);
            createEventGetters(option, jClass);

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

    // TODO create a specific visitor when we will have all cases ready
    private static void createEventGetters(Option option, JDefinedClass jClass)
    {
        if (EventHelper.getType(option.getFullname()) == EventType.Series)
        {
            // equals based on fullname
            JClass series = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(new Option("series", "", ""), OutputType.Interface));
            jClass.method(JMod.NONE, series, EventHelper.GET_SERIES_METHOD_NAME);
        }
        // TODO add point case

    }

    public static JDefinedClass createEventHandlerInterface(Option option, String packageName, String rootDirectoryPathName)
    {
        JCodeModel model = new JCodeModel();

        JDefinedClass jClass = null;

        try
        {
            String eventName = EventHelper.getEventNamePrefix(option);
            String handlerName = eventName + EventHelper.HANDLER_SUFFIX;
            String fullyqualifiedName = packageName + "." + handlerName;
            jClass = model._class(fullyqualifiedName, ClassType.INTERFACE);

            JClass eventClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));

            jClass.method(JMod.NONE, void.class, EventHelper.ON_PREFIX + eventName).param(eventClass, paramName(eventName));

            // ClassRegistry.INSTANCE.put(option, OutputType.Interface, jClass);
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

        return jClass;

    }

    private static String paramName(String eventName)
    {
        return eventName.substring(0, 1).toLowerCase() + eventName.substring(1) + EventHelper.EVENT_SUFFIX;
    }

    public static void addHandlerRegistrationMethods(Option option, JDefinedClass jClass, JDefinedClass eventHandlerInterface)
    {
        
        //http://jsfiddle.net/gv2yp218/
        String className = eventHandlerInterface.name();
        String paramName = className.substring(0, 1).toLowerCase() + className.substring(1);
        jClass.method(JMod.NONE, void.class, EventHelper.ADD_HANDLER_METHOD_PREFIX + className).param(eventHandlerInterface, paramName(paramName));
    }
}
