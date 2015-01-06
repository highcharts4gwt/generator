package com.github.highcharts4gwt.generator.highsoft;

import javax.annotation.CheckForNull;

public enum ConfigurationType
{
    Option
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(ConfigurationTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitOption(in);
        }

        @Override
        public String getPackageName()
        {
            return "option";
        }
    },
    Object
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(ConfigurationTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitObject(in);
        }

        @Override
        public String getPackageName()
        {
            return "object";
        }
    };

    @CheckForNull
    public abstract <IN, OUT> OUT accept(ConfigurationTypeVisitor<IN, OUT> visitor, IN in);

    public abstract String getPackageName();
}
