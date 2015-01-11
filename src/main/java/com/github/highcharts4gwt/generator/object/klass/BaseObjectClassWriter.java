package com.github.highcharts4gwt.generator.object.klass;

import java.io.File;
import java.io.IOException;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.ObjectOrOptionUtils;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.object.Object;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public abstract class BaseObjectClassWriter implements ObjectClassWriter
{

    private final String rootDirectory;
    private String packageName;
    private Object object;
    private String shortClassName;

    @CheckForNull
    private JCodeModel codeModel;

    public BaseObjectClassWriter(String rootDirectory)
    {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public ObjectClassWriter setPackageName(String packageName)
    {
        this.packageName = packageName;
        return this;
    }

    @Override
    public ObjectClassWriter setOject(Object object)
    {
        this.object = object;
        this.shortClassName = ObjectOrOptionUtils.getShortClassName(object);
        return this;
    }

    public Object getObject()
    {
        return object;
    }

    public JCodeModel getCodeModel()
    {
        return codeModel;
    }

    @Override
    public void createClass() throws IOException, JClassAlreadyExistsException
    {
        codeModel = new JCodeModel();
        JDefinedClass jClass = declareType(packageName, shortClassName);

        ClassRegistry.INSTANCE.put(object, getOutputType(), jClass);
    }

    @Override
    public void writeClassToDisk() throws IOException
    {
        if (codeModel != null) // CS
            codeModel.build(new File(rootDirectory));
    }

    protected abstract JDefinedClass declareType(String packageName, String className) throws JClassAlreadyExistsException;

    protected abstract String getPrefix();

    protected abstract OutputType getOutputType();

    protected abstract ClassType getClassType();

}
