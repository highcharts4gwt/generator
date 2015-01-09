package com.github.highcharts4gwt.generator.option.field;

import com.sun.codemodel.JDefinedClass;

public abstract class AbstractFieldWriter
{
    public AbstractFieldWriter(JDefinedClass jClass, boolean pipe, String fieldName)
    {
        this.jClass = jClass;
        this.pipe = pipe;
        this.names = Names.create(fieldName, getNameExtension(), pipe, isParamNameSpecial());
    }

    protected boolean isParamNameSpecial()
    {
        return false;
    }

    protected abstract String getNameExtension();

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
    private final JDefinedClass jClass;
    private final Names names;
}
