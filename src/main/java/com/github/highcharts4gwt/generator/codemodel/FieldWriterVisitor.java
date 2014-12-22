package com.github.highcharts4gwt.generator.codemodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.codemodel.field.FieldArrayJsonObjectWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldArrayNumberWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldArrayObjectWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldArrayStringWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldBooleanWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldEventWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldJsonObjectWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldNumberWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldObjectWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldStringWriter;
import com.github.highcharts4gwt.generator.codemodel.field.FieldTypeVisitor;
import com.github.highcharts4gwt.generator.graph.Option;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldWriterVisitor implements FieldTypeVisitor<OutputType, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldWriterVisitor.class);

    private final String fieldName;
    private final JCodeModel codeModel;
    private final JDefinedClass jClass;
    private final String className;
    private final Option option;

    private final boolean pipe;

    private final String rootDirectoryPath;

    public FieldWriterVisitor(Option option, JCodeModel codeModel, JDefinedClass jClass, String className, boolean pipe, String rootDirectoryPath)
    {
        this.option = option;
        this.pipe = pipe;
        this.rootDirectoryPath = rootDirectoryPath;
        this.fieldName = option.getTitle();
        this.codeModel = codeModel;
        this.jClass = jClass;
        this.className = className;
    }

    @Override
    public Void visitNumber(OutputType in)
    {
        return in.accept(new FieldNumberWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitBoolean(OutputType in)
    {
        return in.accept(new FieldBooleanWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitString(OutputType in)
    {
        return in.accept(new FieldStringWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayString(OutputType in)
    {
        return in.accept(new FieldArrayStringWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayNumber(OutputType in)
    {
        return in.accept(new FieldArrayNumberWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayObject(OutputType in)
    {
        return in.accept(new FieldArrayObjectWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitObject(OutputType in)
    {
        return in.accept(new FieldObjectWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitJsonObject(OutputType in)
    {
        return in.accept(new FieldJsonObjectWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayJsonObject(OutputType in)
    {
        return in.accept(new FieldArrayJsonObjectWriter(codeModel, jClass, className, option, pipe, fieldName), null);
    }

    @Override
    public Void visitFunction(OutputType in)
    {
        // TODO support function
        return null;
    }

    @Override
    public Void visitEvent(OutputType in)
    {
        return in.accept(new FieldEventWriter(codeModel, jClass, className, option, pipe, fieldName, rootDirectoryPath), null);
    }
}
