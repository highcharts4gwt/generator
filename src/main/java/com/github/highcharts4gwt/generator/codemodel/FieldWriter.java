package com.github.highcharts4gwt.generator.codemodel;

import com.github.highcharts4gwt.generator.graph.Option;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public interface FieldWriter
{
    void writeField(Option option, OutputType outputType, String rootDirectoryPath);

    void setCodeModel(JCodeModel codeModel);

    void setJclass(JDefinedClass jClass);

    void setClassName(String className);
}
