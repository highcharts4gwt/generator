package com.github.highcharts4gwt.generator.option.field;

public interface EventTypeVisitor<IN, OUT>
{
    OUT visitSeries(IN in);

    OUT visitChart(IN in);

    OUT visitPoint(IN in);

    OUT visitAxis(IN in);
}
