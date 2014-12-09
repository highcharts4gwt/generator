package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;
import com.usesoft.highcharts4gwt.generator.graph.OptionsData;

public interface ClassWriter
{
    ClassWriter setPackageName(String packageName);

    void write() throws IOException, JClassAlreadyExistsException;

    ClassWriter setOption(Option optionSpec, OptionsData optionsData);

    ClassWriter setTree(OptionTree tree);

    void setExtendedOption(Option extendedOption);

}
