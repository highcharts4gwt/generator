package com.github.highcharts4gwt.generator.option.field;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.field.FieldType;
import com.github.highcharts4gwt.generator.common.field.FieldTypeHelper;
import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.klass.BaseClassWriter;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public final class BaseFieldWriter implements FieldWriter
{
    private static final Logger logger = LoggerFactory.getLogger(BaseClassWriter.class);

    private JCodeModel codeModel;
    private JDefinedClass jClass;
    private String shortClassNameWithPrefix;

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
    public void setShortClassNameWithPrefix(String shortClassNameWithPrefix)
    {
        this.shortClassNameWithPrefix = shortClassNameWithPrefix;
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
            fieldType.accept(new FieldWriterVisitor(option, jClass, pipe, rootDirectoryPath), outputType);
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
