package com.github.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.github.highcharts4gwt.generator.codemodel.OutputType;
import com.github.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.graph.Option;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldObjectWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final String defaultValue;
    private final Option option;
    private final JClass interfaceJClass;
    private String fullName;

    public FieldObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
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
            JsoFieldHelper.addEventHandlerRegistrationMethods(option, getJclass(), getCodeModel());
        }
        else
        {
            JsoFieldHelper.writeGetterNativeCodeObject(getNames(), interfaceJClass, getJclass(), getCodeModel(), defaultValue);
            JsoFieldHelper.writeSetterNativeCode(getNames(), interfaceJClass, getJclass(), getCodeModel());
        }
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        if (fullName.endsWith("events"))
        {
            MockFieldHelper.addEventHandlerRegistrationMethods(option, getJclass(), getCodeModel());
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
