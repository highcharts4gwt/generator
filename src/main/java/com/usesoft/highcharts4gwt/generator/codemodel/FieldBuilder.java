package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JCodeModel;

public interface FieldBuilder
{
    void setCodeModel(JCodeModel codeModel);

    void addNumberField(String fieldName);

    void addStringField(String fieldName);

    void addBooleanField(String fieldName);

    void addObjectField(String fieldName);

    void addFunctionField(String fieldName);

    void addColorField(String fieldName);

    void addMixedField(String fieldName);

    void addCssObjectField(String fieldName);

    <T> void addArrayField(String fieldName, T type);

    <T> void addField(String fieldName, T type);
}
