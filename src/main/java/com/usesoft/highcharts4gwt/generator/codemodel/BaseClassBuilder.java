package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.File;
import java.io.IOException;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public abstract class BaseClassBuilder implements ClassBuilder
{
    @CheckForNull
    private JCodeModel codeModel;

    private final String rootDirectory;

    @CheckForNull
    private String basePackageName;

    @CheckForNull
    private JDefinedClass optionsClass;

    private String fullyQualifiedName;

    public BaseClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public void build() throws IOException, JClassAlreadyExistsException
    {
        codeModel = new JCodeModel();
        optionsClass = codeModel._class(basePackageName + "." + getPrefix() + fullyQualifiedName);

        if (codeModel != null) // CS
            codeModel.build(new File(rootDirectory));
    }

    public abstract String getPrefix();

    @Override
    public void setBasePackageName(String basePackageName)
    {
        this.basePackageName = basePackageName;
    }

    @Override
    public void setFullyQualifiedName(String fullyQualifiedName)
    {
        this.fullyQualifiedName = fullyQualifiedName;
    }
}
