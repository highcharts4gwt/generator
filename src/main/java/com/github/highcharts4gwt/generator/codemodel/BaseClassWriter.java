package com.github.highcharts4gwt.generator.codemodel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.graph.Option;
import com.github.highcharts4gwt.generator.graph.OptionTree;
import com.github.highcharts4gwt.generator.graph.OptionUtils;
import com.github.highcharts4gwt.generator.graph.OptionsData;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
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

    private Option extendedOption;

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

        addExtension();

        if (tree == null)
            throw new RuntimeException("Need to set the tree to build a class");

        writeFields();

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

    private void writeFields()
    {
        initFieldBuilder();

        if (tree == null || option == null)
            throw new RuntimeException("tree/option should not be null");

        List<Option> fieldToAdd = findFieldToReallyAdd(tree.getChildren(option), getFieldFromExtendedOptionRecursive(extendedOption, optionsData));

        for (Option option : fieldToAdd)
        {
            fieldWriter.writeField(option, getOutputType(), rootDirectory);
        }
    }

    private List<Option> findFieldToReallyAdd(List<Option> children, List<Option> extendingChildren)
    {
        List<Option> options = Lists.newArrayList();
        if (children != null)
        {
            for (Option child : children)
            {
                if(isFieldNeeded(extendingChildren, child, options))
                    options.add(child);
            }
        }
        return options;
    }

    private boolean isFieldNeeded(List<Option> existingChildren, Option child, List<Option> out)
    {
        String optionName = child.getTitle();
        //special case for events
        if (child.getFullname().endsWith("events." + optionName) || child.getFullname().endsWith("events"))
            return true;
        boolean alreadyInExtended = false;
        for (Option existingChild : existingChildren)
        {
            if (existingChild.getTitle().equals(optionName))
            {
                alreadyInExtended = true;
                break;
            }
        }

        if (!alreadyInExtended)
        {
            if (extendedOption != null)
                logger.info("Adding field;" + child + "for class;" + option + ";not present in extended class;" + extendedOption);
            return true;
        }
        return false;
    }

    private void initFieldBuilder()
    {
        fieldWriter.setJclass(jClass);
        fieldWriter.setCodeModel(codeModel);
        fieldWriter.setClassName(getPrefix() + className);
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

    @Override
    public void setExtendedOption(Option extendedOption)
    {
        this.extendedOption = extendedOption;
    }
}
