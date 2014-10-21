package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldObjectWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{

    private final String defaultValue;
    private final Option option;
    private final JClass interfaceJClass;

    public FieldObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option)
    {
        super(codeModel, className, jClass);
        this.option = option;
        this.defaultValue = option.getDefaults();
        interfaceJClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(this.option, OutputType.Interface));
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {

        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, interfaceJClass, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        JsoFieldHelper.writeGetterNativeCodeObject(fieldName, interfaceJClass, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, interfaceJClass, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        MockFieldHelper.addGetterSetterDeclaration(fieldName, fieldName, interfaceJClass, getJclass());
        return null;
    }

}
