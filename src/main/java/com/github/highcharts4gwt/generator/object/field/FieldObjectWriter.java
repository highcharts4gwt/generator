package com.github.highcharts4gwt.generator.object.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.object.Object;
import com.github.highcharts4gwt.generator.option.field.AbstractFieldWriter;
import com.github.highcharts4gwt.generator.option.field.InterfaceFieldHelper;
import com.github.highcharts4gwt.generator.option.field.JsoFieldHelper;
import com.github.highcharts4gwt.generator.option.field.MockFieldHelper;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;

public class FieldObjectWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final JClass interfaceJClass;
    private final String className;
    private final Object object;

    public FieldObjectWriter(JDefinedClass jClass, boolean pipe, String fieldName, Object object)
    {
        super(jClass, pipe, fieldName);
        this.object = object;
        className = object.getReturnType().substring(0, 1).toUpperCase() + object.getReturnType().substring(1);
        interfaceJClass = ClassRegistry.INSTANCE.getRegistry().get(
                new ClassRegistry.RegistryKey(new Object(className, className, className), OutputType.Interface));
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterDeclaration(getNames(), interfaceJClass, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.writeGetterNativeCodeObject(getNames(), interfaceJClass, getJclass(), null);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterDeclaration(getNames(), interfaceJClass, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsObject";
    }
}
