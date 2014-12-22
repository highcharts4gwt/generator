package com.github.highcharts4gwt.generator.codemodel.field;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.github.highcharts4gwt.generator.codemodel.EventRegistry;
import com.github.highcharts4gwt.generator.codemodel.OutputType;
import com.github.highcharts4gwt.generator.graph.Option;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;

public class InterfaceFieldHelper
{
    private static final Logger logger = LoggerFactory.getLogger(InterfaceFieldHelper.class);

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

            // write getter for Series / Point or Chart inside event
            EventHelper.getType(option).accept(new EventGetterWriterVisitor(option, jClass, model), OutputType.Interface);

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

            jClass.method(JMod.NONE, void.class, EventHelper.ON_PREFIX + eventName).param(eventClass, EventHelper.paramName(eventName));

            EventRegistry.INSTANCE.put(EventHelper.getRegistryKey(option), jClass);
            logger.info("Handler created;" + handlerName);

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

    public static void addEventHandlerRegistrationMethods(Option option, JDefinedClass jClass)
    {

        List<JClass> list = EventRegistry.INSTANCE.getRegistry().get(option.getFullname());
        if (list != null)
        {
            for (JClass handlerClass : list)
            {
                String handlerClassName = handlerClass.name();
                String paramName = handlerClassName.substring(0, 1).toLowerCase() + handlerClassName.substring(1);
                jClass.method(JMod.NONE, void.class, EventHelper.ADD_HANDLER_METHOD_PREFIX + handlerClassName).param(handlerClass, paramName);
            }
        }

    }
}
