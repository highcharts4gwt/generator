package com.github.highcharts4gwt.generator.option;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.klass.InterfaceClassWriter;
import com.github.highcharts4gwt.generator.option.klass.JsoClassWriter;
import com.github.highcharts4gwt.generator.option.klass.MockClassWriter;
import com.github.highcharts4gwt.generator.option.klass.OptionClassWriter;
import com.sun.codemodel.JClassAlreadyExistsException;

public class OptionClassWritterVisitor implements OutputTypeVisitor<String, OptionClassWriter>
{

    @Override
    public OptionClassWriter visitInterface(String in)
    {
        try
        {
            return new InterfaceClassWriter(in);
        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException("Cannot instantiate InterfaceClassBuilder");
        }
    }

    @Override
    public OptionClassWriter visitJso(String in)
    {
        try
        {
            return new JsoClassWriter(in);
        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException("Cannot instantiate JsoClassBuilder");
        }
    }

    @Override
    public OptionClassWriter visitMock(String in)
    {
        try
        {
            return new MockClassWriter(in);
        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException("Cannot instantiate MockClassBuilder");
        }
    }

}
