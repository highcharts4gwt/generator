package com.usesoft.highcharts4gwt.generator.codemodel.field;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public abstract class FieldWriter
{
    public FieldWriter(JCodeModel codeModel, String className, JDefinedClass jClass, boolean pipe, String fieldName)
    {
        this.codeModel = codeModel;
        this.className = className;
        this.jClass = jClass;
        this.pipe = pipe;
        this.names = Names.create(fieldName, getNameExtension(), pipe, isParamNameSpecial());
    }

    protected boolean isParamNameSpecial()
    {
        return false;
    }

    protected abstract String getNameExtension();

    protected JCodeModel getCodeModel()
    {
        return codeModel;
    }

    protected String getClassName()
    {
        return this.className;
    }

    protected JDefinedClass getJclass()
    {
        return jClass;
    }

    public boolean hasPipe()
    {
        return pipe;
    }

    public Names getNames()
    {
        return names;
    }

    private final boolean pipe;
    private final JCodeModel codeModel;
    private final JDefinedClass jClass;
    private final String className;
    private final Names names;
}
