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
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionUtils;

public abstract class BaseClassBuilder implements ClassBuilder
{
    @CheckForNull
    private JCodeModel codeModel;

    private final String rootDirectory;

    @CheckForNull
    private String packageName;

    @CheckForNull
    private JDefinedClass optionsClass;

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

        optionsClass = declareType(packageName, className);

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

    public abstract String getPrefix();

    @Override
    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    @Override
    public void setOptionSpec(OptionSpec optionSpec)
    {
        this.optionSpec = optionSpec;
        this.className = OptionUtils.getClassName(optionSpec);
    }

    @Override
    public void setTree(OptionTree tree)
    {
        this.tree = tree;
    }

    public JCodeModel getCodeModel()
    {
        return codeModel;
    }

    protected JDefinedClass declareType(String packageName, String className) throws JClassAlreadyExistsException
    {
        // JClass iface;
        // ._implements(iface);
        return getCodeModel()._class(packageName + "." + getPrefix() + className, getClassType());
    }

    protected ClassType getClassType()
    {
        return ClassType.CLASS;
    }
}
