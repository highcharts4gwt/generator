package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;
import com.usesoft.highcharts4gwt.generator.graph.OptionsData;

public interface ClassBuilder
{
    ClassBuilder setPackageName(String packageName);

    void build() throws IOException, JClassAlreadyExistsException;

    ClassBuilder setOption(Option optionSpec, OptionsData optionsData);

    ClassBuilder setTree(OptionTree tree);

    void setExtendedOption(Option extendedOption);

}
