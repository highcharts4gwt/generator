package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;

public interface ClassBuilder
{
    void setBasePackageName(String basePackageName);

    void setFullyQualifiedName(String fullyQualifiedName);

    void build() throws IOException, JClassAlreadyExistsException;
}
