package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.ClassRegistry;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldObjectWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{

    private final String defaultValue;
    private final Option option;
    private final JClass interfaceJClass;

    public FieldObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.option = option;
        this.defaultValue = option.getDefaults();
        interfaceJClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(this.option, OutputType.Interface));
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {

        // For events, need to add handler on series object
        String fullName = option.getFullname();
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
        String fullName = option.getFullname();
        if (fullName.endsWith("events"))
        {

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
        String fullName = option.getFullname();
        if (fullName.endsWith("events"))
        {

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
