package com.github.highcharts4gwt.generator.common;

import javax.annotation.CheckForNull;

public interface OutputTypeVisitor<IN, OUT>
{
    @CheckForNull
    OUT visitInterface(IN in);

    @CheckForNull
    OUT visitJso(IN in);

    @CheckForNull
    OUT visitMock(IN in);
}
