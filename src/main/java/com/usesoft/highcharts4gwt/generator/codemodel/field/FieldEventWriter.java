package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldEventWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{
    private final String defaultValue;
    private final Option option;
    private final String rootDirectoryPath;

    public FieldEventWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName,
            String rootDirectoryPath)
    {
        super(codeModel, className, jClass, pipe, fieldName);
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

        return null;
    }

    @Override
    @CheckForNull
    public Void visitMock(Void in)
    {

        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "";
    }

}
