package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.NativeContentHack;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;

public class EventContextGetterWriterVisitor implements OutputTypeVisitor<Void, Void>
{
    private final JDefinedClass jClass;
    private final com.github.highcharts4gwt.generator.object.Object contextObjectKey;
    private final String context;
    private final String getterName;

    public EventContextGetterWriterVisitor(Option option, JDefinedClass jClass)
    {
        this.jClass = jClass;
        this.context = option.getContext();
        this.getterName = context.substring(0, 1).toLowerCase() + context.substring(1);
        contextObjectKey = new com.github.highcharts4gwt.generator.object.Object(context, "", "");
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        JClass contextObjectClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(contextObjectKey, OutputType.Interface));
        jClass.method(JMod.NONE, contextObjectClass, getterName);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JClass contextObjectClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(contextObjectKey, OutputType.Interface));

        NativeContentHack getterContentHack = new NativeContentHack(JsoFieldHelper.getContextObject());
        jClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, contextObjectClass, getterName)._throws(getterContentHack);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {

        JClass contextObjectClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(contextObjectKey, OutputType.Interface));

        JFieldVar field = jClass.field(JMod.PRIVATE, contextObjectClass, context);
        JMethod getter = jClass.method(JMod.PUBLIC, contextObjectClass, getterName);
        JBlock block = getter.body();
        block._return(field);

        return null;
    }

}
