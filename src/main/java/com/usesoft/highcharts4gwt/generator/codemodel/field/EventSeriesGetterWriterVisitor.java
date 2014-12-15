package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.codemodel.klass.NativeContentHack;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class EventSeriesGetterWriterVisitor implements OutputTypeVisitor<Void, Void>
{
    private final Option option;
    private final JDefinedClass jClass;
    private final JCodeModel jCodeModel;

    public EventSeriesGetterWriterVisitor(Option option, JDefinedClass jClass, JCodeModel jCodeModel)
    {
        this.option = option;
        this.jClass = jClass;
        this.jCodeModel = jCodeModel;
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        JClass series = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(new Option("series", "", ""), OutputType.Interface));
        jClass.method(JMod.NONE, series, EventHelper.GET_SERIES_METHOD_NAME);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        NativeContentHack getterContentHack = new NativeContentHack(jCodeModel, JsoFieldHelper.getJsniSeriesEventGetter());
        JClass series = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(new Option("series", "", ""), OutputType.Interface));

        jClass.method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, series, EventHelper.GET_SERIES_METHOD_NAME)._throws(getterContentHack);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        // TODO Add mock implement for series event getter
        return null;
    }

}
