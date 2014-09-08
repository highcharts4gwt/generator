package com.usesoft.highcharts4gwt.generator.codemodel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.CheckForNull;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;
import com.usesoft.highcharts4gwt.generator.graph.OptionTree;
import com.usesoft.highcharts4gwt.generator.graph.OptionUtils;

public abstract class BaseClassBuilder implements ClassBuilder
{
    @CheckForNull
    private JCodeModel codeModel;

    private final String rootDirectory;

    @CheckForNull
    private String packageName;

    @CheckForNull
    private JDefinedClass jClass;

    private String className;

    @CheckForNull
    private OptionSpec optionSpec;

    @CheckForNull
    private OptionTree tree;

    public BaseClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
    {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public void build() throws IOException, JClassAlreadyExistsException
    {
        codeModel = new JCodeModel();

        jClass = declareType(packageName, className);

        getFieldBuilder().setJclass(jClass);

        ClassRegistry.INSTANCE.put(optionSpec, getOutputType(), jClass);

        if (tree == null)
            throw new RuntimeException("Need to set the tree to build a class");

        List<OptionSpec> children = tree.getParentToChildrenRelations().get(optionSpec);

        if (children != null)
        {
            for (OptionSpec optionSpec : children)
            {
                getFieldBuilder().addField(optionSpec);
            }
        }

        if (codeModel != null) // CS
            codeModel.build(new File(rootDirectory));
    }

    @Override
    public ClassBuilder setPackageName(String packageName)
    {
        this.packageName = packageName;
        return this;
    }

    @Override
    public ClassBuilder setOptionSpec(OptionSpec optionSpec)
    {
        this.optionSpec = optionSpec;
        this.className = OptionUtils.getClassName(optionSpec);
        return this;
    }

    @Override
    public ClassBuilder setTree(OptionTree tree)
    {
        this.tree = tree;
        return this;
    }

    protected abstract FieldBuilder getFieldBuilder();

    protected abstract String getPrefix();

    protected abstract OutputType getOutputType();

    protected abstract JDefinedClass declareType(String packageName, String className) throws JClassAlreadyExistsException;

    protected abstract ClassType getClassType();

    protected JCodeModel getCodeModel()
    {
        return codeModel;
    }

    protected OptionSpec getOptionSpec()
    {
        return optionSpec;
    }

}
