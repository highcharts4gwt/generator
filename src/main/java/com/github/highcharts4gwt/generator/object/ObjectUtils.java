package com.github.highcharts4gwt.generator.object;

import java.util.List;

import com.github.highcharts4gwt.generator.ObjectOrOption;

public class ObjectUtils
{
    private ObjectUtils()
    {
    }

    public static List<Object> sortListBasedOnDependencies(List<Object> objects)
    {
        return objects;
    }

    public static String getShortClassName(ObjectOrOption hasFullName)
    {
        String fullName = hasFullName.getFullname();
        int index = fullName.lastIndexOf(".");
        String className = fullName.substring(index + 1, index + 2).toUpperCase() + fullName.substring(index + 2);

        return className;
    }
}
