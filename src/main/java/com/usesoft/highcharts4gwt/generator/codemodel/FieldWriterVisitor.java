package com.usesoft.highcharts4gwt.generator.codemodel;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayJsonObjectWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayNumberWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayObjectWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayStringWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldBooleanWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldDataWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldJsonObjectWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldNumberWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldObjectWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldStringWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldWriterVisitor implements FieldTypeVisitor<OutputType, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldWriterVisitor.class);

    private final String fieldName;
    private final JCodeModel codeModel;
    private final JDefinedClass jClass;
    private final String className;
    private final Option option;

    public FieldWriterVisitor(Option optionSpec, JCodeModel codeModel, JDefinedClass jClass, String className)
    {
        this.option = optionSpec;
        this.fieldName = optionSpec.getTitle();
        this.codeModel = codeModel;
        this.jClass = jClass;
        this.className = className;
    }

    @Override
    public Void visitNumber(OutputType in)
    {
        String defaultValue = null;
        String fromOption = option.getDefaults();
        defaultValue = getDefaultValueForNumber(fromOption);

        return in.accept(new FieldNumberWriter(codeModel, jClass, className, defaultValue), fieldName);
    }

    private String getDefaultValueForNumber(@CheckForNull String fromOption)
    {
        // TODO Report to HS - Strange cases with numbers - empty or undefined ?
        String defaultValue;
        if (fromOption == null || fromOption.equals("null"))
        {
            defaultValue = "null";
        }
        else if (fromOption.equals("undefined"))
        {
            defaultValue = "undefined";
        }
        else if (fromOption.equals(""))
        {
            defaultValue = "''";
        }
        else
        {
            defaultValue = Double.toString(Double.parseDouble(fromOption));
        }
        return defaultValue;
    }

    @Override
    public Void visitBoolean(OutputType in)
    {
        return in.accept(new FieldBooleanWriter(codeModel, jClass, className, Boolean.parseBoolean(option.getDefaults())), fieldName);
    }

    @Override
    public Void visitString(OutputType in)
    {
        return in.accept(new FieldStringWriter(codeModel, jClass, className, option.getDefaults()), fieldName);
    }

    @Override
    public Void visitOther(OutputType in)
    {
        return null;
    }

    @Override
    public Void visitArrayString(OutputType in)
    {
        return in.accept(new FieldArrayStringWriter(codeModel, jClass, className, option.getDefaults()), fieldName);
    }

    @Override
    public Void visitArrayNumber(OutputType in)
    {
        return in.accept(new FieldArrayNumberWriter(codeModel, jClass, className, option.getDefaults()), fieldName);
    }

    @Override
    public Void visitArrayObject(OutputType in)
    {
        return in.accept(new FieldArrayObjectWriter(codeModel, jClass, className, option), fieldName);
    }

    @Override
    public Void visitClass(OutputType in)
    {
        return in.accept(new FieldObjectWriter(codeModel, jClass, className, option), fieldName);
    }

    @Override
    public Void visitData(OutputType in)
    {
        return in.accept(new FieldDataWriter(codeModel, jClass, className, option.getDefaults()), fieldName);
    }

    @Override
    public Void visitJsonObject(OutputType in)
    {
        // TODO should precise that this is an "object" not a string value
        return in.accept(new FieldJsonObjectWriter(codeModel, jClass, className, option.getDefaults()), fieldName);
    }

    @Override
    public Void visitCssObject(OutputType in)
    {
        // TODO should precise that this is an "object" not a string value
        return in.accept(new FieldJsonObjectWriter(codeModel, jClass, className, option.getDefaults()), fieldName);
    }

    @Override
    public Void visitArrayJsonObject(OutputType in)
    {
        return in.accept(new FieldArrayJsonObjectWriter(codeModel, className, jClass, option), fieldName);
    }
}
