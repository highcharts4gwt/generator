package com.github.highcharts4gwt.generator.object.field;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.object.Object;
import com.github.highcharts4gwt.generator.option.field.AbstractFieldWriter;
import com.github.highcharts4gwt.generator.option.field.InterfaceFieldHelper;
import com.github.highcharts4gwt.generator.option.field.JsoFieldHelper;
import com.github.highcharts4gwt.generator.option.field.MockFieldHelper;
import com.github.highcharts4gwt.model.array.api.Array;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayObjectWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayObjectWriter.class);
    private final Object object;

    public FieldArrayObjectWriter(JDefinedClass jClass, boolean pipe, String fieldName, Object object)
    {
        super(jClass, pipe, fieldName, object.getDescription());
        this.object = object;
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        JClass fieldClazz = getNarrowedArrayClass();
        if (fieldClazz == null)
            return null;

        InterfaceFieldHelper.addGetterDeclaration(getNames(), fieldClazz, getJclass());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JClass fieldClazz = getNarrowedArrayClass();
        if (fieldClazz == null)
            return null;

        JsoFieldHelper.writeGetterNativeCodeArrayObject(getNames(), fieldClazz, getJclass(), null);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        JClass fieldClazz = getNarrowedArrayClass();
        if (fieldClazz == null)
            return null;

        MockFieldHelper.addGetterDeclaration(getNames(), fieldClazz, getJclass());
        return null;
    }

    private JClass getNarrowedArrayClass()
    {
        // extract
        String narrowedClass = null;
        if (!hasPipe())
        {
            narrowedClass = object.getReturnType().substring(6, object.getReturnType().length() - 1);
        }
        else
        {
            logger.error("Array with pipe not supported for object;" + object.getFullname());
            return null;
        }

        ClassRegistry.RegistryKey key = new ClassRegistry.RegistryKey(new Object(narrowedClass, narrowedClass, narrowedClass), OutputType.Interface);
        JClass jClass = ClassRegistry.INSTANCE.getRegistry().get(key);

        if (jClass == null)
        {
            logger.error("Could not create field Array<>;" + object.getFullname());
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
