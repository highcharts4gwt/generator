package com.usesoft.highcharts4gwt.generator.highsoft;

import javax.annotation.CheckForNull;

public enum Product
{
    Highcharts
    {
        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(ProductVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitHighcharts(in);
        }

        @Override
        public String getPackageName()
        {
            return "highcharts";
        }
    },
    Highmaps
    {
        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(ProductVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitHighmaps(in);
        }

        @Override
        public String getPackageName()
        {
            return "highmaps";
        }
    },
    Highstock
    {
        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(ProductVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitHighstock(in);
        }

        @Override
        public String getPackageName()
        {
            return "highstock";
        }
    };

    @CheckForNull
    public abstract <IN, OUT> OUT accept(ProductVisitor<IN, OUT> visitor, IN in);

    public abstract String getPackageName();

}
