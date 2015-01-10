package com.github.highcharts4gwt.generator.object.klass;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;

public class ObjectClassWritterVisitor implements OutputTypeVisitor<String, ObjectClassWriter>
{

    @Override
    public ObjectClassWriter visitInterface(String in)
    {
        return new ObjectInterfaceClassWriter(in);
    }

    @Override
    public ObjectClassWriter visitJso(String in)
    {
        return new ObjectJsoClassBuilder(in);
    }

    @Override
    public ObjectClassWriter visitMock(String in)
    {
        return new ObjectMockClassBuilder(in);
    }

}
