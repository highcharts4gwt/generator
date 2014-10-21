package com.usesoft.highcharts4gwt.generator.codemodel.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldArrayJsonObjectWriter extends FieldWriter implements OutputTypeVisitor<String, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldArrayJsonObjectWriter.class);
    private final Option optionSpec;
    private final String defaultValue;

    public FieldArrayJsonObjectWriter(JCodeModel codeModel, String className, JDefinedClass jClass, Option optionSpec)
    {
        super(codeModel, className, jClass);
        this.optionSpec = optionSpec;
        this.defaultValue = optionSpec.getDefaults();
    }

    @Override
    public Void visitInterface(String fieldName)
    {
        String paramName = computeParamName(fieldName);

        InterfaceFieldHelper.addGetterSetterDeclaration(fieldName, paramName, String.class, getJclass());
        return null;
    }

    @Override
    public Void visitJso(String fieldName)
    {
        String paramName = computeParamName(fieldName);

        JsoFieldHelper.writeGetterNativeCodeArrayJsonObject(fieldName, String.class, getJclass(), getCodeModel(), defaultValue);
        JsoFieldHelper.writeSetterNativeCodeWithParse(fieldName, paramName, String.class, getJclass(), getCodeModel());
        return null;
    }

    @Override
    public Void visitMock(String fieldName)
    {
        String paramName = computeParamName(fieldName);

        MockFieldHelper.addGetterSetterDeclaration(fieldName, paramName, String.class, getJclass());
        return null;
    }

    private String computeParamName(String fieldName)
    {
        return fieldName + "AsJsonStringArray";
    }

}
