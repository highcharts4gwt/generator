package com.github.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.github.highcharts4gwt.generator.codemodel.OutputType;
import com.github.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.graph.Option;
import com.github.highcharts4gwt.model.array.api.Array;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayObjectWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayObjectWriter.class);

    private final String defaultValue;
    private final Option option;

    public FieldArrayObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.option = option;
        this.defaultValue = option.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        JClass fieldClazz = getRealClass();
        if (fieldClazz == null)
            return null;

        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), fieldClazz, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JClass fieldClazz = getRealClass();
        if (fieldClazz == null)
            return null;

        JsoFieldHelper.writeGetterNativeCodeArrayObject(getNames(), fieldClazz, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), fieldClazz, getJclass(), getCodeModel());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        JClass fieldClazz = getRealClass();
        if (fieldClazz == null)
            return null;

        MockFieldHelper.addGetterSetterDeclaration(getNames(), fieldClazz, getJclass());
        return null;
    }

    private JClass getRealClass()
    {
        // use interface type
        JClass jClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));

        if (jClass == null)
        {
            logger.error("Could not create Array<Object> for type " + option.getFullname());
            return null;
        }

        JClass rawLLclazz = getCodeModel().ref(Array.class);
        JClass fieldClazz = rawLLclazz.narrow(jClass);
        return fieldClazz;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsArrayObject";
    }
}