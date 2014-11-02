package com.usesoft.highcharts4gwt.generator.codemodel.field;

public class Names
{
    // need a fieldName for mocks and a field name for Jso. Mocks are different
    // not jso

    private final String originalFieldName;

    private final String paramName;
    private final String getterName;
    private final String setterName;
    private final String mockFieldName;

    private Names(String originalFieldName, String mockFieldName, String paramName, String getterName, String setterName)
    {
        this.originalFieldName = originalFieldName;
        this.mockFieldName = mockFieldName;
        this.paramName = paramName;
        this.getterName = getterName;
        this.setterName = setterName;
    }

    public String getOriginalFieldName()
    {
        return originalFieldName;
    }

    public String getMockFieldName()
    {
        return mockFieldName;
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

    // public static Names createAllSame(String fieldName)
    // {
    // return new Names(fieldName, mockFieldName, fieldName, fieldName,
    // fieldName);
    // }
    //
    // public static Names createParamDifferent(String fieldName, String
    // paramName)
    // {
    // return new Names(fieldName, mockFieldName, paramName, fieldName,
    // fieldName);
    // }

    public static Names create(String originalFieldName, String extension, boolean pipe, boolean specialParamName)
    {
        String getterName = originalFieldName;
        String setterName = originalFieldName;
        String mockfieldName = originalFieldName;

        String paramName = originalFieldName;
        if (pipe)
        {
            mockfieldName = originalFieldName + extension;
            getterName = originalFieldName + extension;
            setterName = originalFieldName + extension;
            paramName = originalFieldName + extension;
        }
        if (specialParamName)
        {
            paramName = originalFieldName + extension;
        }

        return new Names(originalFieldName, mockfieldName, paramName, getterName, setterName);
    }
}
