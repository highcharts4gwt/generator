package com.usesoft.highcharts4gwt.generator.codemodel;

import javax.annotation.CheckForNull;

public enum OutputType
{
    Interface
    {
        @Override
        public String getRootPackageName()
        {
            return "api";
        }

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(OutputTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitInterface(in);
        }
    },
    Jso
    {
        @Override
        public String getRootPackageName()
        {
            return "jso";
        }

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(OutputTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitJso(in);
        }
    },
    Mock
    {
        @Override
        public String getRootPackageName()
        {
            return "mock";
        }

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(OutputTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitMock(in);
        }
    };

    @CheckForNull
    public abstract <IN, OUT> OUT accept(OutputTypeVisitor<IN, OUT> visitor, IN in);

    public abstract String getRootPackageName();

}
