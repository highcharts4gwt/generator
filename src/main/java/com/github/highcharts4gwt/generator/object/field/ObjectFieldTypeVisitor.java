package com.github.highcharts4gwt.generator.object.field;

public interface ObjectFieldTypeVisitor<IN, OUT>
{
    OUT visitMethod(IN in);

    OUT visitProperty(IN in);

    OUT visitNull(IN in);

}
