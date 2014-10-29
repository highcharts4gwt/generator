package com.usesoft.highcharts4gwt.generator.codemodel.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldArrayJsonObjectWriter extends FieldWriter implements OutputTypeVisitor<Void, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayJsonObjectWriter.class);
    private final Option option;
    private final String defaultValue;

    public FieldArrayJsonObjectWriter(JCodeModel codeModel, String className, JDefinedClass jClass, Option option, boolean pipe, String fieldName)
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
        String paramName = computeParamName(fieldName);

        JsoFieldHelper.writeGetterNativeCodeArrayJsonObject(fieldName, String.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCodeWithParse(fieldName, paramName, String.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    public Void visitMock(Void in)
    {
        // TODO remove this go to NAME
        String paramName = computeParamName(fieldName);

        MockFieldHelper.addGetterSetterDeclaration(fieldName, paramName, paramName, String.class, getJclass());
        return null;
    }

    // TODO remove this go to NAME
    private String computeParamName(String fieldName)
    {
        return fieldName + "AsJsonStringArray";
    }

    @Override
    protected String getNameExtension()
    {
        return "AsJsonStringArray";
    }

}
