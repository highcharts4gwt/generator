package com.github.highcharts4gwt.generator.codemodel;

import java.io.IOException;

import com.github.highcharts4gwt.generator.graph.Option;
import com.github.highcharts4gwt.generator.graph.OptionTree;
import com.github.highcharts4gwt.generator.graph.OptionsData;
import com.sun.codemodel.JClassAlreadyExistsException;

public interface ClassWriter
{
    ClassWriter setPackageName(String packageName);

    void write() throws IOException, JClassAlreadyExistsException;

    ClassWriter setOption(Option optionSpec, OptionsData optionsData);

    ClassWriter setTree(OptionTree tree);

    void setExtendedOption(Option extendedOption);

}
