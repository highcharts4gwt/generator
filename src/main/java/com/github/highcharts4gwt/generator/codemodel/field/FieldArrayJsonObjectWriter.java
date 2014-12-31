package com.github.highcharts4gwt.generator.codemodel.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.graph.Option;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayJsonObjectWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayJsonObjectWriter.class);
    private final Option option;
    private final String defaultValue;

    public FieldArrayJsonObjectWriter(JCodeModel codeModel, JDefinedClass jClass, String className, Option option, boolean pipe, String fieldName)
    {
        super(codeModel, className, jClass, pipe, fieldName);
        this.option = option;
        this.defaultValue = option.getDefaults();
    }

    @Override
    protected boolean isParamNameSpecial()
    {
        return true;
    }

    @Override
    public Void visitInterface(Void in)
    {
        InterfaceFieldHelper.addGetterSetterDeclaration(getNames(), String.class, getJclass());
        return null;
    }

    @Override
    public Void visitJso(Void in)
    {

        JsoFieldHelper.writeGetterNativeCodeArrayJsonObject(getNames(), String.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCodeWithParse(getNames(), String.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    public Void visitMock(Void in)
    {
        MockFieldHelper.addGetterSetterDeclaration(getNames(), String.class, getJclass());
        return null;
    }

    @Override
    protected String getNameExtension()
    {
        return "AsJsonStringArray";
    }

}