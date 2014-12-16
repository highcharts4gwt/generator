package com.usesoft.highcharts4gwt.generator.codemodel.field;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.EventRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class MockFieldHelper
{
    private MockFieldHelper()
    {
    }

    public static void addGetterSetterDeclaration(Names names, Class<?> type, JDefinedClass jDefinedClass)
    {
        JFieldVar field = jDefinedClass.field(JMod.PRIVATE, type, names.getMockFieldName());

        JMethod getter = jDefinedClass.method(JMod.PUBLIC, type, names.getGetterName());
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = jDefinedClass.method(JMod.PUBLIC, jDefinedClass, names.getSetterName());
        JVar setterParam = setter.param(type, names.getParamName());

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    public static void addGetterSetterDeclaration(Names names, JClass type, JDefinedClass jDefinedClass)
    {
        JFieldVar field = jDefinedClass.field(JMod.PRIVATE, type, names.getMockFieldName());

        JMethod getter = jDefinedClass.method(JMod.PUBLIC, type, names.getGetterName());
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = jDefinedClass.method(JMod.PUBLIC, jDefinedClass, names.getSetterName());
        JVar setterParam = setter.param(type, names.getParamName());

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());
    }

    public static void addEventHandlerRegistrationMethods(Option option, JDefinedClass jClass, JCodeModel codeModel)
    {
        List<JClass> list = EventRegistry.INSTANCE.getRegistry().get(option.getFullname());
        if (list != null)
        {
            for (JClass handlerClass : list)
            {
                String handlerClassName = handlerClass.name();
                String paramName = "handler";
                JMethod method = jClass.method(JMod.PUBLIC, void.class, EventHelper.ADD_HANDLER_METHOD_PREFIX + handlerClassName);
                method.param(handlerClass, paramName);
            }
        }

    }

    public static void createEventMock(Option option, String packageName, String rootDirectoryPath)
    {
        JCodeModel model = new JCodeModel();

        try
        {
            JDefinedClass jClass = model._class(packageName + "." + OutputType.Mock.toString() + EventHelper.getEventNamePrefix(option)
                    + EventHelper.EVENT_SUFFIX, ClassType.CLASS);

            JClass eventClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));

            jClass._implements(eventClass);

            // write getter for Series / Point or Chart inside event
            EventHelper.getType(option).accept(new EventGetterWriterVisitor(option, jClass, model), OutputType.Mock);

            ClassRegistry.INSTANCE.put(option, OutputType.Mock, jClass);

        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            model.build(new File(rootDirectoryPath));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
