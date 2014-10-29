package com.usesoft.highcharts4gwt.generator.codemodel.field;

public class Names
{
    private final String fieldName;
    private final String paramName;
    private final String getterName;
    private final String setterName;

    private Names(String fieldName, String paramName, String getterName, String setterName)
    {
        this.fieldName = fieldName;
        this.paramName = paramName;
        this.getterName = getterName;
        this.setterName = setterName;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public String getParamName()
    {
        return paramName;
    }

    public String getGetterName()
    {
        return getterName;
    }

    public String getSetterName()
    {
        return setterName;
    }

    public static Names createAllSame(String fieldName)
    {
        return new Names(fieldName, fieldName, fieldName, fieldName);
    }

    public static Names createParamDifferent(String fieldName, String paramName)
    {
        return new Names(fieldName, paramName, fieldName, fieldName);
    }

    public static Names create(String baseName, String extension, boolean pipe, boolean specialParamName)
    {
        String composed = baseName;
        String paramName = baseName;
        if (pipe)
            composed = baseName + extension;
        if (specialParamName)
        {
            paramName = baseName + extension;
        }

        return new Names(composed, paramName, composed, baseName);
    }
}
