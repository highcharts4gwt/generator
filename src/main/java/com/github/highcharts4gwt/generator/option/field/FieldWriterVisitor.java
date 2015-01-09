package com.github.highcharts4gwt.generator.option.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.FieldTypeVisitor;
import com.github.highcharts4gwt.generator.OutputType;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JDefinedClass;

public class FieldWriterVisitor implements FieldTypeVisitor<OutputType, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldWriterVisitor.class);

    private final String fieldName;
    private final JDefinedClass jClass;
    private final Option option;

    private final boolean pipe;

    private final String rootDirectoryPath;

    // TODO remove rootDirectoryPath if possible, jClass or package should be
    // enough ?
    public FieldWriterVisitor(Option option, JDefinedClass jClass, boolean pipe, String rootDirectoryPath)
    {
        this.option = option;
        this.pipe = pipe;
        this.rootDirectoryPath = rootDirectoryPath;
        this.fieldName = option.getTitle();
        this.jClass = jClass;
    }

    @Override
    public Void visitNumber(OutputType in)
    {
        return in.accept(new FieldNumberWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitBoolean(OutputType in)
    {
        return in.accept(new FieldBooleanWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitString(OutputType in)
    {
        return in.accept(new FieldStringWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayString(OutputType in)
    {
        return in.accept(new FieldArrayStringWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayNumber(OutputType in)
    {
        return in.accept(new FieldArrayNumberWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayObject(OutputType in)
    {
        return in.accept(new FieldArrayObjectWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitObject(OutputType in)
    {
        return in.accept(new FieldObjectWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitJsonObject(OutputType in)
    {
        return in.accept(new FieldJsonObjectWriter(jClass, option, pipe, fieldName), null);
    }

    @Override
    public Void visitArrayJsonObject(OutputType in)
    {
        return in.accept(new FieldArrayJsonObjectWriter(jClass, option, pipe, fieldName), null);
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
        return in.accept(new FieldEventWriter(jClass, option, pipe, fieldName, rootDirectoryPath), null);
    }

    @Override
    public Void visitElement(OutputType in)
    {
        throw new RuntimeException("Element type is not supported by options");
    }
}
