package com.github.highcharts4gwt.generator;

import com.github.highcharts4gwt.generator.codemodel.ClassWriter;
import com.github.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.codemodel.klass.InterfaceClassBuilder;
import com.github.highcharts4gwt.generator.codemodel.klass.JsoClassBuilder;
import com.github.highcharts4gwt.generator.codemodel.klass.MockClassBuilder;
import com.sun.codemodel.JClassAlreadyExistsException;

public class ClassWritterVisitor implements OutputTypeVisitor<String, ClassWriter>
{

    @Override
    public ClassWriter visitInterface(String in)
    {
        try
        {
            return new InterfaceClassBuilder(in);
        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException("Cannot instantiate InterfaceClassBuilder");
        }
    }

    @Override
    public ClassWriter visitJso(String in)
    {
        try
        {
            return new JsoClassBuilder(in);
        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException("Cannot instantiate JsoClassBuilder");
        }
    }

    @Override
    public ClassWriter visitMock(String in)
    {
        try
        {
            return new MockClassBuilder(in);
        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException("Cannot instantiate MockClassBuilder");
        }
    }

}
