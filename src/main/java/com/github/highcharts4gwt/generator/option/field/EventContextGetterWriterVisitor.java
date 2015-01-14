package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.NativeContentHack;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;

public class EventContextGetterWriterVisitor implements OutputTypeVisitor<Void, Void>
{
    private final Option option;
    private final JDefinedClass jClass;
    private final JCodeModel jCodeModel;
    private final com.github.highcharts4gwt.generator.object.Object contextObjectKey;
    private final String context;

    public EventContextGetterWriterVisitor(Option option, JDefinedClass jClass, JCodeModel jCodeModel)
    {
        this.option = option;
        this.jClass = jClass;
        this.jCodeModel = jCodeModel;
        this.context = option.getContext();
        contextObjectKey = new com.github.highcharts4gwt.generator.object.Object(context, "", "");
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        JClass series = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(contextObjectKey, OutputType.Interface));
        jClass.method(JMod.NONE, series, EventHelper.GET_SERIES_METHOD_NAME);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        NativeContentHack getterContentHack = new NativeContentHack(JsoFieldHelper.getJsniSeriesEventGetter());
        JClass series = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(contextObjectKey, OutputType.Interface));

        jClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, series, EventHelper.GET_SERIES_METHOD_NAME)._throws(getterContentHack);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {

        JClass series = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(contextObjectKey, OutputType.Interface));

        JFieldVar field = jClass.field(JMod.PRIVATE, series, context);

        JMethod getter = jClass.method(JMod.PUBLIC, series, "get" + context.substring(0, 1).toUpperCase() + context.substring(1));
        JBlock block = getter.body();
        block._return(field);

        JMethod setter = jClass.method(JMod.PUBLIC, jClass, context);
        JVar setterParam = setter.param(series, context);

        setter.body().assign(JExpr._this().ref(field), setterParam)._return(JExpr._this());

        return null;
    }

}
