package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.model.array.api.Array;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayObjectWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayObjectWriter.class);

    private final String defaultValue;
    private final Option option;

    public FieldArrayObjectWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName, option.getDescription());
        this.option = option;
        this.defaultValue = option.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        JClass fieldClazz = getNarrowedArrayClass();
        if (fieldClazz == null)
            return null;

        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), fieldClazz, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JClass fieldClazz = getNarrowedArrayClass();
        if (fieldClazz == null)
            return null;

        JsoFieldHelper.writeGetterNativeCodeArrayObject(getNames(), fieldClazz, getJclass(), defaultValue);
        JsoFieldHelper.writeSetterNativeCode(getNames(), fieldClazz, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        JClass fieldClazz = getNarrowedArrayClass();
        if (fieldClazz == null)
            return null;

        MockFieldHelper.addGetterSetterDeclaration(getNames(), fieldClazz, getJclass());
        return null;
    }

    private JClass getNarrowedArrayClass()
    {
        // use interface type
        JClass jClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));

        if (jClass == null)
        {
            logger.error("Could not create Array<Object> for type " + option.getFullname());
            return null;
        }

        JClass genericArray = new JCodeModel().ref(Array.class);
        JClass arrayOfSpecializedType = genericArray.narrow(jClass);
        return arrayOfSpecializedType;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsArrayObject";
    }
}
