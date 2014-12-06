package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public interface FieldBuilder
{
    void addField(Option optionSpec, OutputType outputType, String rootDirectoryPath);

    void setCodeModel(JCodeModel codeModel);

    void setJclass(JDefinedClass jClass);

    void setClassName(String className);
}
