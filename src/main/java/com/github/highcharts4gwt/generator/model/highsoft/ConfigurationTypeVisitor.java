package com.github.highcharts4gwt.generator.model.highsoft;

import javax.annotation.CheckForNull;

public interface ConfigurationTypeVisitor<IN, OUT>
{
    @CheckForNull
    OUT visitOption(IN in);

    @CheckForNull
    OUT visitObject(IN in);
}
