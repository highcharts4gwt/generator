package com.github.highcharts4gwt.generator.option.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JDefinedClass;

public class FieldArrayJsonObjectWriter extends AbstractFieldWriter implements OutputTypeVisitor<Void, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayJsonObjectWriter.class);
    private final Option option;
    private final String defaultValue;

    public FieldArrayJsonObjectWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, pipe, fieldName, option.getDescription());
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

        JsoFieldHelper.writeGetterNativeCodeArrayJsonObject(getNames(), String.class, getJclass(), defaultValue);
        JsoFieldHelper.writeSetterNativeCodeWithParse(getNames(), String.class, getJclass());
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
