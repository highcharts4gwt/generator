package com.github.highcharts4gwt.generator.object;

import javax.annotation.CheckForNull;

public enum ObjectFieldType
{
    Method
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(ObjectFieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitMethod(in);
        }
    },
    Property
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(ObjectFieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitProperty(in);
        }
    },
    Null
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(ObjectFieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitNull(in);
        }
    };

    @CheckForNull
    public abstract <IN, OUT> OUT accept(ObjectFieldTypeVisitor<IN, OUT> visitor, IN in);
}
