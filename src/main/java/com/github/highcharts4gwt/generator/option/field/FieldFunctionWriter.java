package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JDefinedClass;

public class FieldFunctionWriter extends AbstractFieldWriter implements OutputTypeVisitor<Object, Void>
{
    
    private Option option;

    public FieldFunctionWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName, option.getDescription());
        this.option = option;
    }
    
    @Override
    @CheckForNull
    public Void visitInterface(Object in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Object in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Object in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
