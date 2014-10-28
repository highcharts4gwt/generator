package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.model.array.api.Array;

public class FieldArrayObjectWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayObjectWriter.class);

    private final String defaultValue;
    private final Option optionSpec;

    public FieldArrayObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option optionSpec, boolean pipe)
    {
        super(codeModel, className, jClass, pipe);
        this.optionSpec = optionSpec;
        this.defaultValue = optionSpec.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(String fieldName)
    {
        JClass fieldClazz = getRealClass();
        if (fieldClazz == null)
            return null;

        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, fieldClazz, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(String fieldName)
    {
        JClass fieldClazz = getRealClass();
        if (fieldClazz == null)
            return null;

        JsoFieldHelper.writeGetterNativeCodeArrayObject(fieldName, fieldClazz, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(fieldName, fieldClazz, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(String fieldName)
    {
        JClass fieldClazz = getRealClass();
        if (fieldClazz == null)
            return null;

        MockFieldHelper.addGetterSetterDeclaration(fieldName, computeFieldName(fieldName), fieldName, fieldClazz, getJclass());
        return null;
    }

    private JClass getRealClass()
    {
        // use interface type
        JClass jClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(optionSpec, OutputType.Interface));

        if (jClass == null)
        {
            logger.error("Could not create Array<Object> for type " + optionSpec.getFullname());
            return null;
        }

        JClass rawLLclazz = getCodeModel().ref(Array.class);
        JClass fieldClazz = rawLLclazz.narrow(jClass);
        return fieldClazz;
    }

    private String computeFieldName(String fieldName)
    {
        return fieldName + "AsArrayObject";
    }
}
