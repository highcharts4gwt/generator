package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.graph.Option;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;
import com.usesoft.highcharts4gwt.generator.graph.OptionUtils;
import com.usesoft.highcharts4gwt.generator.graph.OptionsData;

public abstract class BaseClassBuilder implements ClassBuilder
{
    private static final Logger logger = LoggerFactory.getLogger(BaseClassBuilder.class);

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

    private final BaseFieldBuilder fieldBuilder;

    private Option extendedOption;

    private OptionsData optionsData;

    public BaseClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        this.rootDirectory = rootDirectory;
        fieldBuilder = new BaseFieldBuilder();
    }

    @Override
    public void build() throws IOException, JClassAlreadyExistsException
    {
        JClass found = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(option, getOutputType()));
        if (found != null)
        {
            logger.info("Already written;" + option);
            return;
        }

        codeModel = new JCodeModel();
        jClass = declareType(packageName, className);

        addExtension();

        if (tree == null)
            throw new RuntimeException("Need to set the tree to build a class");

        buildFields();

        writeClassToFileSystem();

        ClassRegistry.INSTANCE.put(option, getOutputType(), jClass);
    }

    private void addExtension()
    {
        if (extendedOption != null)
        {
            JClass extendedJclass = ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(extendedOption, getOutputType()));
            if (extendedJclass == null)
            {
                logger.error("Missing extendedJClass;" + extendedOption);
                throw new RuntimeException("Missing extendedJClass;" + extendedOption);
            }

            if (jClass == null)
                throw new RuntimeException("jClass should not be null");

            jClass._extends(extendedJclass);
        }
    }

    private void writeClassToFileSystem() throws IOException
    {
        if (codeModel != null) // CS
            codeModel.build(new File(rootDirectory));
    }

    private void buildFields()
    {
        initFieldBuilder();

        List<Option> existingChildren = getFieldFromExtendedOptionRecursive(extendedOption, optionsData);

        if (tree == null || option == null)
            throw new RuntimeException("tree/option should not be null");

        List<Option> children = tree.getChildren(option);

        if (children != null)
        {
            for (Option child : children)
            {
                addField(existingChildren, child);
            }
        }
    }

    private void addField(List<Option> existingChildren, Option child)
    {
        String optionName = child.getTitle();
        boolean alreadyInExtended = false;
        for (Option existingChild : existingChildren)
        {
            if (existingChild.getTitle().equals(optionName))
                alreadyInExtended = true;
        }

        if (!alreadyInExtended)
        {
            if (extendedOption != null)
                logger.info("Adding field;" + child + "for class;" + option + ";not present in extended class;" + extendedOption);
            fieldBuilder.addField(child, getOutputType(), rootDirectory);
        }
    }

    private void initFieldBuilder()
    {
        fieldBuilder.setJclass(jClass);
        fieldBuilder.setCodeModel(codeModel);
        fieldBuilder.setClassName(getPrefix() + className);
    }

    private static List<Option> getFieldFromExtendedOptionRecursive(Option extendedOption, OptionsData optionsData)
    {
        List<Option> existingChildren = new ArrayList<Option>();
        if (extendedOption != null)
        {
            OptionTree extendedOptionTree = optionsData.findTree(extendedOption);
            existingChildren = extendedOptionTree.getChildren(extendedOption);

            if (!Strings.isNullOrEmpty(extendedOption.getExtending()))
            {
                Option optionRecursive = optionsData.findExtendedOption(extendedOption, optionsData);
                if (optionRecursive != null)
                    existingChildren.addAll(getFieldFromExtendedOptionRecursive(optionRecursive, optionsData));
            }

        }
        return existingChildren;
    }

    @Override
    public ClassBuilder setPackageName(String packageName)
    {
        this.packageName = packageName;
        return this;
    }

    @Override
    public ClassBuilder setOption(Option optionSpec, OptionsData optionsData)
    {
        this.option = optionSpec;
        this.optionsData = optionsData;
        this.className = OptionUtils.getClassName(optionSpec);
        return this;
    }

    @Override
    public ClassBuilder setTree(OptionTree tree)
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

    @Override
    public void setExtendedOption(Option extendedOption)
    {
        this.extendedOption = extendedOption;
    }
}
