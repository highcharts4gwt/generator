package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

public enum EventType
{
    Series
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(EventTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitSeries(in);
        }
    },
    Point
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(EventTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitPoint(in);
        }
    },
    Chart
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(EventTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitChart(in);
        }
    },
    Axis
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(EventTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitAxis(in);
        }
    },
    PlotLineOrBand
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(EventTypeVisitor<IN, OUT> visitor, IN in)
        {
            // TODO what to do with that case ?
            return null;
        }
    },
    DoNotTreat
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(EventTypeVisitor<IN, OUT> visitor, IN in)
        {
            return null;
        }
    };

    @CheckForNull
    public abstract <IN, OUT> OUT accept(EventTypeVisitor<IN, OUT> visitor, IN in);
}
