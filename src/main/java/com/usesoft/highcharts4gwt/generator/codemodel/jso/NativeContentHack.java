package com.usesoft.highcharts4gwt.generator.codemodel.jso;

import java.util.Iterator;
import java.util.List;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JTypeVar;

public class NativeContentHack extends JClass
{

    private final String nativeContent;

    public NativeContentHack(JCodeModel codeModel, String nativeContent)
    {
        super(codeModel);
        this.nativeContent = nativeContent;

    }

    @Override
    public String name()
    {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<JClass> _implements()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isInterface()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAbstract()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected JClass substituteParams(JTypeVar[] variables, List<JClass> bindings)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String fullName()
    {
        // TODO Auto-generated method stub
        return "";
    }

}
