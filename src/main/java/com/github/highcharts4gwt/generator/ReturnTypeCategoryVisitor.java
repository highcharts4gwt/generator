package com.github.highcharts4gwt.generator;

public interface ReturnTypeCategoryVisitor<IN, OUT>
{
    OUT visitSimple(IN in);

    OUT visitSimpleWithPipe(IN in);

    OUT visitArray(IN in);

    OUT visitArrayWithPipe(IN in);
}
