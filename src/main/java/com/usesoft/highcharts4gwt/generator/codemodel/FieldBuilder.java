package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public interface FieldBuilder
{
    void addField(OptionSpec optionSpec, OutputType outputType);

    void setCodeModel(JCodeModel codeModel);

    void setJclass(JDefinedClass jClass);

    void setClassName(String className);
}
