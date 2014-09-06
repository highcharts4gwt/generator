package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;

public interface ClassBuilder
{
    void setBasePackageName(String basePackageName);

    void build() throws IOException, JClassAlreadyExistsException;
    
    FieldBuilder getFieldBuilder();

	void setOptionSpec(OptionSpec optionSpec);

	void setTree(OptionTree tree);
}
