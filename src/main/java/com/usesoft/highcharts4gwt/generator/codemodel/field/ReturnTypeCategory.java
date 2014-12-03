package com.usesoft.highcharts4gwt.generator.codemodel.field;

import java.util.regex.Matcher;

import javax.annotation.CheckForNull;

public enum ReturnTypeCategory
{
    Simple
    {
        @Override
        public <IN, OUT> OUT accept(ReturnTypeCategoryVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitSimple(in);
        }
    },
    SimpleWithPipe
    {
        @Override
        public <IN, OUT> OUT accept(ReturnTypeCategoryVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitSimpleWithPipe(in);
        }
    },
    Array
    {
        @Override
        public <IN, OUT> OUT accept(ReturnTypeCategoryVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArray(in);
        }
    },
    ArrayWithPipe
    {
        @Override
        public <IN, OUT> OUT accept(ReturnTypeCategoryVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArrayWithPipe(in);
        }
    };

    private Matcher matcher;

    @CheckForNull
    public abstract <IN, OUT> OUT accept(ReturnTypeCategoryVisitor<IN, OUT> visitor, IN in);

    public void setMatcher(@CheckForNull Matcher matcher)
    {
        this.matcher = matcher;
    }

    @CheckForNull
    public Matcher getMatcher()
    {
        return matcher;
    }
}
