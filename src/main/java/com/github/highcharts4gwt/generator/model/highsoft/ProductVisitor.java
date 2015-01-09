package com.github.highcharts4gwt.generator.model.highsoft;

import javax.annotation.CheckForNull;

public interface ProductVisitor<IN, OUT>
{
    @CheckForNull
    OUT visitHighcharts(IN in);

    @CheckForNull
    OUT visitHighmaps(IN in);

    @CheckForNull
    OUT visitHighstock(IN in);
}
