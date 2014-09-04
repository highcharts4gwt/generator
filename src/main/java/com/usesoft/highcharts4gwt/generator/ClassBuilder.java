package com.usesoft.highcharts4gwt.generator;

import java.io.File;
import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionUtils;

public class ClassBuilder
{
    private final JCodeModel codeModel;
    private final String rootDirectory;
    private final OptionSpec optionSpec;
    private final String packageName;
    private final JDefinedClass optionsClass;

    public ClassBuilder(String rootDirectory, String packageName, OptionSpec optionSpec) throws JClassAlreadyExistsException
    {
        this.rootDirectory = rootDirectory;
        this.packageName = packageName;
        this.optionSpec = optionSpec;
        codeModel = new JCodeModel();
        optionsClass = codeModel._class(packageName + "." + OptionUtils.getFullyQualifiedName(optionSpec));
    }

    public void build() throws IOException
    {
        codeModel.build(new File(rootDirectory));
    }
}
