package com.github.highcharts4gwt.generator.option.field;

import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;


//TODO delete this class completely useless

public class EventGetterWriterVisitor implements EventTypeVisitor<OutputType, Void>
{
    private final Option option;
    private final JDefinedClass jClass;
    private final JCodeModel jCodeModel;

    public EventGetterWriterVisitor(Option option, JDefinedClass jClass, JCodeModel jCodeModel)
    {
        this.option = option;
        this.jClass = jClass;
        this.jCodeModel = jCodeModel;
    }

    @Override
    public Void visitSeries(OutputType in)
    {
        in.accept(new EventContextGetterWriterVisitor(option, jClass), null);
        return null;
    }

    @Override
    public Void visitChart(OutputType in)
    {
        in.accept(new EventContextGetterWriterVisitor(option, jClass), null);
        return null;
    }

    @Override
    public Void visitPoint(OutputType in)
    {
        in.accept(new EventContextGetterWriterVisitor(option, jClass), null);
        return null;
    }

    @Override
    public Void visitAxis(OutputType in)
    {
        in.accept(new EventContextGetterWriterVisitor(option, jClass), null);
        return null;
    }

}
