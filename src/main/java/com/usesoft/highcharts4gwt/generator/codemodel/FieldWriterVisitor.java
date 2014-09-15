package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldBooleanWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldNumberWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldStringWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldTypeVisitor;

public class FieldWriterVisitor implements FieldTypeVisitor<OutputType, Void>
{
    private final String fieldName;
    private final JCodeModel codeModel;
    private final JDefinedClass jClass;
    private final String className;

    public FieldWriterVisitor(String fieldName, JCodeModel codeModel, JDefinedClass jClass, String className)
    {
        this.fieldName = fieldName;
        this.codeModel = codeModel;
        this.jClass = jClass;
        this.className = className;
    }

    @Override
    public Void visitNumber(OutputType in)
    {
        return in.accept(new FieldNumberWriter(codeModel, jClass, className), fieldName);
    }

    @Override
    public Void visitBoolean(OutputType in)
    {
        return in.accept(new FieldBooleanWriter(codeModel, jClass, className), fieldName);
    }

    @Override
    public Void visitString(OutputType in)
    {
        return in.accept(new FieldStringWriter(codeModel, jClass, className), fieldName);
    }

    @Override
    public Void visitOther(OutputType in)
    {
        return null;
    }
}
