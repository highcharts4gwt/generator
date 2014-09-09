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
        String methodOutput = "Number";
        getJclass().direct(getGetterCode(fieldName, methodOutput, fieldName));

        getJclass().direct(getSetterCode(fieldName, methodOutput, fieldName, getClassName()));
    }

    @Override
    public void addStringField(String fieldName)
    {
        String methodOutput = "String";
        getJclass().direct(getGetterCode(fieldName, methodOutput, fieldName));

        getJclass().direct(getSetterCode(fieldName, methodOutput, fieldName, getClassName()));
    }

    @Override
    public void addBooleanField(String fieldName)
    {
        String methodOutput = "boolean";
        getJclass().direct(getGetterCode(fieldName, methodOutput, fieldName));

        getJclass().direct(getSetterCode(fieldName, methodOutput, fieldName, getClassName()));
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
        getCodeModel().ref(jClass.getClass());

        getJclass().field(JMod.PRIVATE, jClass, fieldName + "ForImport");

        String methodOutput = jClass.name();
        getJclass().direct(getGetterCode(fieldName, methodOutput, fieldName));

        getJclass().direct(getSetterCode(fieldName, methodOutput, fieldName, getClassName()));

    }

    private static String getGetterCode(String fieldName, String methodOutput, String methodName)
    {
        return "\n    @Override\n" + "    public native final " + methodOutput + " " + methodName + "()/*-{\n" + "        return this[\"" + fieldName
                        + "\"] = (this[\"" + fieldName + "\"] || {});\n" + "    }-*/;\n\n";

    }

    private static String getSetterCode(String fieldName, String fieldType, String methodName, String className)
    {
        return "\n    @Override\n" + "    public native final " + className + " " + methodName + "(" + fieldType + " " + fieldName + ")/*-{\n"
                        + "        this[\"" + fieldName + "\"] = " + fieldName + ";\n" + "        return this;\n" + "    }-*/;\n\n";
    }

    // Write by by hand -> import pb
    // private static String getGetterCode(String fieldName, String methodOutput, String methodName)
    // {
    // return "\n    @Override\n" + "    public native " + methodOutput + " " + methodName + "()/*{\n" + "        return this[\"" + fieldName
    // + "\"] = (this[\"" + fieldName + "\"] || {});\n" + "    }*/;\n\n";
    //
    // }
    //
    // private static String getSetterCode(String fieldName, String fieldType, String methodName, String className)
    // {
    // return "\n    @Override\n" + "    public native " + className + " " + methodName + "(" + fieldType + " " + fieldName + ")/*{\n" + "        this[\""
    // + fieldName + "\"] = " + fieldName + ";\n" + "        return this;\n" + "    }*/;\n\n";
    // }
    //
    // @Override
    // public void addNumberField(String fieldName)
    // {
    // String methodOutput = "Number";
    // getJclass().direct(getGetterCode(fieldName, methodOutput, fieldName));
    //
    // getJclass().direct(getSetterCode(fieldName, methodOutput, fieldName, getClassName()));
    // }

    @Override
    protected OutputType getOutputType()
    {
        return OutputType.Jso;
    }

}
