package com.github.highcharts4gwt.generator.option.field;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JDefinedClass;

public class FieldEventWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    private final String defaultValue;
    private final Option option;
    private final String rootDirectoryPath;

    public FieldEventWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName, String rootDirectoryPath)
    {
        super(jClass, pipe, fieldName);
        this.option = option;
        this.rootDirectoryPath = rootDirectoryPath;
        this.defaultValue = option.getDefaults();
    }

    @Override
    @CheckForNull
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.createEventInterface(option, getJclass()._package().name(), rootDirectoryPath);
        InterfaceFieldHelper.createEventHandlerInterface(option, getJclass()._package().name(), rootDirectoryPath);

        return null;
    }

    @Override
    @CheckForNull
    public Void visitJso(Void in)
    {
        JsoFieldHelper.createEventJso(option, getJclass()._package().name(), rootDirectoryPath);
        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {
        MockFieldHelper.createEventMock(option, getJclass()._package().name(), rootDirectoryPath);
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "";
    }

}
