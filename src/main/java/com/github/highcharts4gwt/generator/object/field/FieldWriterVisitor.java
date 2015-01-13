package com.github.highcharts4gwt.generator.object.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.field.FieldTypeVisitor;
import com.sun.codemodel.JDefinedClass;

public class FieldWriterVisitor implements FieldTypeVisitor<OutputType, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(FieldWriterVisitor.class);

    private final String fieldName;
    private final JDefinedClass jClass;
    private final com.github.highcharts4gwt.generator.object.Object object;

    private final boolean pipe;

    private final String rootDirectoryPath;

    // TODO remove rootDirectoryPath if possible, jClass or package should be
    // enough ?
    public FieldWriterVisitor(com.github.highcharts4gwt.generator.object.Object object, JDefinedClass jClass, boolean pipe, String rootDirectoryPath)
    {
        this.object = object;
        this.pipe = pipe;
        this.rootDirectoryPath = rootDirectoryPath;
        this.fieldName = object.getTitle();
        this.jClass = jClass;
    }

    @Override
    public Void visitString(OutputType in)
    {
        return in.accept(new FieldStringWriter(jClass, pipe, fieldName), null);
    }

    @Override
    public Void visitNumber(OutputType in)
    {
        return in.accept(new FieldNumberWriter(jClass, pipe, fieldName), null);
    }

    @Override
    public Void visitBoolean(OutputType in)
    {
        return in.accept(new FieldBooleanWriter(jClass, pipe, fieldName), null);
    }

    @Override
    public Void visitElement(OutputType in)
    {
        // TODO implement that case
        return null;
    }

    @Override
    public Void visitObject(OutputType in)
    {
        return in.accept(new FieldObjectWriter(jClass, pipe, fieldName, object), null);
    }

    @Override
    public Void visitJsonObject(OutputType in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitArrayString(OutputType in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitArrayNumber(OutputType in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitArrayObject(OutputType in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitArrayJsonObject(OutputType in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitFunction(OutputType in)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitEvent(OutputType in)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
