package com.usesoft.highcharts4gwt.generator.codemodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayNumberWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayObjectWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayStringWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldBooleanWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldDataWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldNumberWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldObjectWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldStringWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class FieldWriterVisitor implements FieldTypeVisitor<OutputType, Void>
{
    final static Logger logger = LoggerFactory.getLogger(FieldWriterVisitor.class);

    private final String fieldName;
    private final JCodeModel codeModel;
    private final JDefinedClass jClass;
    private final String className;
    private final Option optionSpec;

    public FieldWriterVisitor(Option optionSpec, JCodeModel codeModel, JDefinedClass jClass, String className)
    {
        this.optionSpec = optionSpec;
        this.fieldName = optionSpec.getTitle();
        this.codeModel = codeModel;
        this.jClass = jClass;
        this.className = className;
    }

    @Override
    public Void visitNumber(OutputType in)
    {
        // System.out.println("fieldName :" + fieldName);
        // System.out.println("Number default :" + optionSpec.getDefaults());

        // TODO Report to HS - Strange cases with numbers ?
        Double defaultValue = null;
        if (optionSpec.getDefaults() != null && !optionSpec.getDefaults().equals("null") && !optionSpec.getDefaults().equals("undefined")
                && !optionSpec.getDefaults().equals(""))
            defaultValue = Double.parseDouble(optionSpec.getDefaults());
        return in.accept(new FieldNumberWriter(codeModel, jClass, className, defaultValue), fieldName);
    }

    @Override
    public Void visitBoolean(OutputType in)
    {
        return in.accept(new FieldBooleanWriter(codeModel, jClass, className, Boolean.parseBoolean(optionSpec.getDefaults())), fieldName);
    }

    @Override
    public Void visitString(OutputType in)
    {
        return in.accept(new FieldStringWriter(codeModel, jClass, className, optionSpec.getDefaults()), fieldName);
    }

    @Override
    public Void visitOther(OutputType in)
    {
        return null;
    }

    @Override
    public Void visitArrayString(OutputType in)
    {
        return in.accept(new FieldArrayStringWriter(codeModel, jClass, className, optionSpec.getDefaults()), fieldName);
    }

    @Override
    public Void visitArrayNumber(OutputType in)
    {
        return in.accept(new FieldArrayNumberWriter(codeModel, jClass, className, optionSpec.getDefaults()), fieldName);
    }

    @Override
    public Void visitArrayObject(OutputType in)
    {
        return in.accept(new FieldArrayObjectWriter(codeModel, jClass, className, optionSpec), fieldName);
    }

    @Override
    public Void visitClass(OutputType in)
    {
        return in.accept(new FieldObjectWriter(codeModel, jClass, className, optionSpec), fieldName);
    }

    @Override
    public Void visitData(OutputType in)
    {
        return in.accept(new FieldDataWriter(codeModel, jClass, className, optionSpec.getDefaults()), fieldName);
    }

    @Override
    public Void visitJsonObject(OutputType in)
    {
        // TODO should precise that this is an "object" not a string value
        return in.accept(new FieldStringWriter(codeModel, jClass, className, optionSpec.getDefaults()), fieldName);
    }

    @Override
    public Void visitCssObject(OutputType in)
    {
        // TODO should precise that this is an "object" not a string value
        return in.accept(new FieldStringWriter(codeModel, jClass, className, optionSpec.getDefaults()), fieldName);
    }
}
