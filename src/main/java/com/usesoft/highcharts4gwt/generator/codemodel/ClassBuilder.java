package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;

public interface ClassBuilder
{
    ClassBuilder setPackageName(String packageName);

    void build() throws IOException, JClassAlreadyExistsException;

    ClassBuilder setOptionSpec(OptionSpec optionSpec);

    ClassBuilder setTree(OptionTree tree);

}
