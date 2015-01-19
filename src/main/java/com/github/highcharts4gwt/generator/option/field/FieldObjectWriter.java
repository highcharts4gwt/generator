package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;

public class FieldObjectWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final String defaultValue;
    private final Option option;
    private final JClass interfaceJClass;
    private final String fullName;

    public FieldObjectWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName);
        this.option = option;
        fullName = option.getFullname();
        this.defaultValue = option.getDefaults();
        interfaceJClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(this.option, OutputType.Interface));
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        if (fullName.endsWith("events"))
        {
            // We are trying to write an event field inside a class.
            // We do not write the field (and getter and setters) but we can add
            // the event handler on the class.
            InterfaceFieldHelper.addEventHandlerRegistrationMethods(option, getJclass());
        }
        else
        {
            InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), interfaceJClass, getJclass());
        }

        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        if (fullName.endsWith("events"))
        {
            JsoFieldHelper.addEventHandlerRegistrationMethods(option, getJclass());
        }
        else
        {
            JsoFieldHelper.writeGetterNativeCodeObject(getNames(), interfaceJClass, getJclass(), defaultValue);
            JsoFieldHelper.writeSetterNativeCode(getNames(), interfaceJClass, getJclass());
        }
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        if (fullName.endsWith("events"))
        {
            MockFieldHelper.addEventHandlerRegistrationMethods(option, getJclass());
        }
        else
        {

            MockFieldHelper.addGetterSetterDeclaration(getNames(), interfaceJClass, getJclass());
        }
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsObject";
    }
}
