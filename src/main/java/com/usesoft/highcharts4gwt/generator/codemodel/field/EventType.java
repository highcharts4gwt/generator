package com.usesoft.highcharts4gwt.generator.codemodel.field;

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
