package com.github.highcharts4gwt.generator.codemodel.field;

public interface FieldTypeVisitor<IN, OUT>
{
    OUT visitNumber(IN in);

    OUT visitBoolean(IN in);

    OUT visitString(IN in);

    OUT visitObject(IN in);

    OUT visitJsonObject(IN in);

    OUT visitArrayString(IN in);

    OUT visitArrayNumber(IN in);

    OUT visitArrayObject(IN in);

    OUT visitArrayJsonObject(IN in);

    OUT visitFunction(IN in);

    OUT visitEvent(IN in);
}
