package com.github.highcharts4gwt.generator.option.klass;

import java.io.IOException;

import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.OptionTree;
import com.sun.codemodel.JClassAlreadyExistsException;

public interface OptionClassWriter
{
    OptionClassWriter setPackageName(String packageName);

    void write() throws IOException, JClassAlreadyExistsException;

    OptionClassWriter setOption(Option optionSpec);

    OptionClassWriter setTree(OptionTree tree);

}
