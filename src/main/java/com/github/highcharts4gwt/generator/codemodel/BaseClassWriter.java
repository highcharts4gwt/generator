package com.github.highcharts4gwt.generator.codemodel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.graph.Option;
import com.github.highcharts4gwt.generator.graph.OptionTree;
import com.github.highcharts4gwt.generator.graph.OptionUtils;
import com.github.highcharts4gwt.generator.graph.OptionsData;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public abstract class BaseClassWriter implements ClassWriter
{
    private static final Logger logger = LoggerFactory.getLogger(BaseClassWriter.class);

    @CheckForNull
    private JCodeModel codeModel;

    private final String rootDirectory;

    @CheckForNull
    private String packageName;

    @CheckForNull
    private JDefinedClass jClass;

    private String className;

    @CheckForNull
    private Option option;

    @CheckForNull
    private OptionTree tree;

    private final BaseFieldWriter fieldWriter;

    private OptionsData optionsData;

    public BaseClassWriter(String rootDirectory) throws JClassAlreadyExistsException
    {
        this.rootDirectory = rootDirectory;
        fieldWriter = new BaseFieldWriter();
    }

    @Override
    public void write() throws IOException, JClassAlreadyExistsException
    {
        JClass found = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, getOutputType()));
        if (found != null)
        {
            logger.trace("Class already written;" + option);
            return;
        }

        codeModel = new JCodeModel();
        jClass = declareType(packageName, className);

        if (tree == null)
            throw new RuntimeException("Need to set the tree to build a class");

        writeFields();

        writeClassToFileSystem();

        ClassRegistry.INSTANCE.put(option, getOutputType(), jClass);
    }

    private void writeClassToFileSystem() throws IOException
    {
        if (codeModel != null) // CS
            codeModel.build(new File(rootDirectory));
    }

    private void writeFields()
    {
        initFieldBuilder();

        if (tree == null || option == null)
            throw new RuntimeException("tree/option should not be null");

        List<Option> fieldToAdd = tree.getChildren(option);

        for (Option option : fieldToAdd)
        {
            fieldWriter.writeField(option, getOutputType(), rootDirectory);
        }
    }

    private void initFieldBuilder()
    {
        fieldWriter.setJclass(jClass);
        fieldWriter.setCodeModel(codeModel);
        fieldWriter.setClassName(getPrefix() + className);
    }

    @Override
    public ClassWriter setPackageName(String packageName)
    {
        this.packageName = packageName;
        return this;
    }

    @Override
    public ClassWriter setOption(Option optionSpec, OptionsData optionsData)
    {
        this.option = optionSpec;
        this.optionsData = optionsData;
        this.className = OptionUtils.getClassName(optionSpec);
        return this;
    }

    @Override
    public ClassWriter setTree(OptionTree tree)
    {
        this.tree = tree;
        return this;
    }

    protected abstract String getPrefix();

    protected abstract OutputType getOutputType();

    protected abstract JDefinedClass declareType(String packageName, String className) throws JClassAlreadyExistsException;

    protected abstract ClassType getClassType();

    protected JCodeModel getCodeModel()
    {
        return codeModel;
    }

    protected Option getOptionSpec()
    {
        return option;
    }
}
