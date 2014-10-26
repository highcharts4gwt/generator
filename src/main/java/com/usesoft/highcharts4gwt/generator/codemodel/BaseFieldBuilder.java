package com.usesoft.highcharts4gwt.generator.codemodel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldType;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldTypeHelper;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public final class BaseFieldBuilder implements FieldBuilder
{
    private static final Logger logger = LoggerFactory.getLogger(BaseClassBuilder.class);

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
    public void addField(Option option, OutputType outputType)
    {

        List<FieldType> types = FieldTypeHelper.findTypes(option);

        for (FieldType fieldType : types)
        {
            fieldType.accept(new FieldWriterVisitor(option, codeModel, jClass, className), outputType);
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
