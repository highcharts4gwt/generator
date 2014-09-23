package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.model.array.api.Array;

public class FieldArrayObjectWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{
    private final String defaultValue;
    private final OptionSpec optionSpec;

    public FieldArrayObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, OptionSpec optionSpec)
    {
        super(codeModel, className, jClass);
        this.optionSpec = optionSpec;
        this.defaultValue = optionSpec.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        JClass fieldClazz = getRealClass();

        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, fieldClazz, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        JClass fieldClazz = getRealClass();

        JsoFieldHelper.writeGetterNativeCodeArrayString(fieldName, fieldClazz, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, fieldClazz, getJclass(), getCodeModel());
        return null;
    }

    private JClass getRealClass()
    {
        // use interface type
        JClass jClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(optionSpec, OutputType.Interface));

        JClass rawLLclazz = getCodeModel().ref(Array.class);
        JClass fieldClazz = rawLLclazz.narrow(jClass);
        return fieldClazz;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        JClass fieldClazz = getRealClass();

        MockFieldHelper.addGetterSetterDeclaration(fieldName, fieldClazz, getJclass());
        return null;
    }

}
