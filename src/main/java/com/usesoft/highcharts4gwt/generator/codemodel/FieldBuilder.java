package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JCodeModel;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public interface FieldBuilder
{
    void addField(OptionSpec optionSpec);

    void setCodeModel(JCodeModel codeModel);
}
