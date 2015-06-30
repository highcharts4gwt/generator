package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;

public class FieldFunctionWriter extends AbstractFieldWriter implements OutputTypeVisitor<Object, Void>
{
    
    private Option option;
    private String rootDirectoryPath;

    public FieldFunctionWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName, String rootDirectoryPath)
    {
        super(jClass, pipe, fieldName, option.getDescription());
        this.option = option;
        this.rootDirectoryPath = rootDirectoryPath;
    }
    
    @Override
    @CheckForNull
    public Void visitInterface(Object in)
    {
        JDefinedClass callbackClass = InterfaceFieldHelper.createFunctionCallbackInterface(option, getJclass()._package().name(), rootDirectoryPath);
        InterfaceFieldHelper.addFunctionSetterDeclaration(getJclass(), callbackClass, getNames());
        
        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Object in)
    {
        
        JClass jClass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));
        
        JsoFieldHelper.addFunctionSetterDeclaration(getJclass(), jClass, getNames());
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Object in)
    {
        JClass callbackType = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, OutputType.Interface));
        
        //TODO implement a fake mechanism ?
        MockFieldHelper.addSetterDeclaration(getNames(), callbackType, getJclass(), null);
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsFunction";
    }

}
