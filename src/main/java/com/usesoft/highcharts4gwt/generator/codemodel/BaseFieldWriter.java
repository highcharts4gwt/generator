package com.usesoft.highcharts4gwt.generator.codemodel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldType;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldTypeHelper;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public final class BaseFieldWriter implements FieldWriter
{
    private static final Logger logger = LoggerFactory.getLogger(BaseClassWriter.class);

    private JCodeModel codeModel;
    private JDefinedClass jClass;
    private String className;

    public JCodeModel getCodeModel()
    {
        return codeModel;
    }

    @Override
    public void setCodeModel(JCodeModel codeModel)
    {
        this.codeModel = codeModel;
    }

    @Override
    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassName()
    {
        return this.className;
    }

    @Override
    public void writeField(Option option, OutputType outputType, String rootDirectoryPath)
    {
        List<FieldType> types = FieldTypeHelper.findTypes(option);
        boolean pipe = false;
        if (types.size() > 1)
            pipe = true;

        for (FieldType fieldType : types)
        {
            fieldType.accept(new FieldWriterVisitor(option, codeModel, jClass, className, pipe, rootDirectoryPath), outputType);
        }
    }

    @Override
    public void setJclass(JDefinedClass jClass)
    {
        this.jClass = jClass;
    }

    protected JDefinedClass getJclass()
    {
        return jClass;
    }

}
