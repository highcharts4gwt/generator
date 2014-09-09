package com.usesoft.highcharts4gwt.generator.codemodel.jso;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JMod;
import com.usesoft.highcharts4gwt.generator.codemodel.BaseFieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.FieldBuilder;
import com.usesoft.highcharts4gwt.generator.codemodel.OutputType;

public class JsoFieldBuilder extends BaseFieldBuilder implements FieldBuilder
{

    @Override
    public void addNumberField(String fieldName)
    {
        NativeContentHack getterContentHack = new NativeContentHack(getCodeModel(), getGetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, Number.class, fieldName)._throws(getterContentHack);

        NativeContentHack setterContentHack = new NativeContentHack(getCodeModel(), getSetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, getJclass(), fieldName)._throws(setterContentHack).param(Number.class, fieldName);
    }

    @Override
    public void addStringField(String fieldName)
    {
        NativeContentHack getterContentHack = new NativeContentHack(getCodeModel(), getGetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, String.class, fieldName)._throws(getterContentHack);

        NativeContentHack setterContentHack = new NativeContentHack(getCodeModel(), getSetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, getJclass(), fieldName)._throws(setterContentHack).param(String.class, fieldName);
    }

    @Override
    public void addBooleanField(String fieldName)
    {
        NativeContentHack getterContentHack = new NativeContentHack(getCodeModel(), getGetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, boolean.class, fieldName)._throws(getterContentHack);

        NativeContentHack setterContentHack = new NativeContentHack(getCodeModel(), getSetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, getJclass(), fieldName)._throws(setterContentHack).param(boolean.class, fieldName);
    }

    @Override
    public void addObjectField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFunctionField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addColorField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addMixedField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addCssObjectField(String fieldName)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addClassField(JClass jClass, String fieldName)
    {
        NativeContentHack getterContentHack = new NativeContentHack(getCodeModel(), getGetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, jClass, fieldName)._throws(getterContentHack);

        NativeContentHack setterContentHack = new NativeContentHack(getCodeModel(), getSetterContent(fieldName));
        getJclass().method(JMod.NATIVE + JMod.FINAL + JMod.PUBLIC, getJclass(), fieldName)._throws(setterContentHack).param(jClass, fieldName);

    }

    private static String getGetterContent(String fieldName)
    {
        return "/*-{\n" + "        return this[\"" + fieldName + "\"] = (this[\"" + fieldName + "\"] || {});\n" + "    }-*/";
    }

    private static String getSetterContent(String fieldName)
    {
        return "/*-{\n" + "        this[\"" + fieldName + "\"] = " + fieldName + ";\n" + "        return this;\n" + "    }-*/";
    }

    // Write by by hand -> import pb
    // private static String getGetterCode(String fieldName, String
    // methodOutput, String methodName)
    // {
    // return "\n    @Override\n" + "    public native final " + methodOutput +
    // " " + methodName + "()" + getGetterContent(fieldName) + ";\n\n";
    // }
    //
    // private static String getSetterCode(String fieldName, String fieldType,
    // String methodName, String className)
    // {
    // return "\n    @Override\n" + "    public native final " + className + " "
    // + methodName + "(" + fieldType + " " + fieldName + ")"
    // + getSetterContent(fieldName) + ";\n\n";
    // }

    //
    // @Override
    // public void addNumberField(String fieldName)
    // {
    // String methodOutput = "Number";
    // getJclass().direct(getGetterCode(fieldName, methodOutput, fieldName));
    //
    // getJclass().direct(getSetterCode(fieldName, methodOutput, fieldName,
    // getClassName()));
    // }

    @Override
    protected OutputType getOutputType()
    {
        return OutputType.Jso;
    }

}
