package com.github.highcharts4gwt.generator.common;

import java.util.Iterator;
import java.util.List;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JTypeVar;

public class NativeContentHack extends JClass
{
    private final String nativeContent;

    public NativeContentHack(String nativeContent)
    {
        super(new JCodeModel());
        this.nativeContent = nativeContent;
    }

    @Override
    public String name()
    {
        return "RuntimeException " + nativeContent;
    }

    @Override
    public JPackage _package()
    {
        return owner()._package("");
    }

    @Override
    public JClass _extends()
    {
        return null;
    }

    @Override
    public Iterator<JClass> _implements()
    {
        return null;
    }

    @Override
    public boolean isInterface()
    {
        return false;
    }

    @Override
    public boolean isAbstract()
    {
        return false;
    }

    @Override
    protected JClass substituteParams(JTypeVar[] variables, List<JClass> bindings)
    {
        return null;
    }

    @Override
    public String fullName()
    {
        return "RuntimeException " + nativeContent;
    }

}
