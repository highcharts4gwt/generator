package com.github.highcharts4gwt.generator.option.field;

import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public interface FieldWriter
{
    void writeField(Option option, OutputType outputType, String rootDirectoryPath);

    void setCodeModel(JCodeModel codeModel);

    void setJclass(JDefinedClass jClass);

    void setShortClassNameWithPrefix(String className);
}
