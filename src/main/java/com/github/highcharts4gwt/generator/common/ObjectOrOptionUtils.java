package com.github.highcharts4gwt.generator.common;

public class ObjectOrOptionUtils
{
    private ObjectOrOptionUtils()
    {
    }

    public static String extractRootFullName(ObjectOrOption objectOrOption)
    {
        String fullname = objectOrOption.getFullname();
        return extractRootFullName(fullname);
    }

    public static String extractRootFullName(String fullname)
    {
        return fullname.split("\\.")[0];
    }

    public static String getShortClassName(ObjectOrOption objectOrOption)
    {
        String fullName = objectOrOption.getFullname();
        int index = fullName.lastIndexOf(".");
        String scn = fullName.substring(index + 1, index + 2).toUpperCase() + fullName.substring(index + 2);
        return scn;
    }

    public static String getPackageName(ObjectOrOption objectOrOption)
    {
        String fullName = objectOrOption.getFullname();
        int index = fullName.lastIndexOf(".");
        if (index != -1)
            return fullName.substring(0, index).toLowerCase();
        return "";
    }

    public static String computePackageName(ObjectOrOption objectOrOption, OutputType outputType, String objectOrOptionPackage)
    {
        String pckg = objectOrOptionPackage + "." + outputType.getPackageName();
        String packageName = ObjectOrOptionUtils.getPackageName(objectOrOption);
        if (!packageName.equalsIgnoreCase(""))
        {
            pckg += "." + packageName;
        }
        return pckg;
    }

    public static boolean isRoot(ObjectOrOption objectOrOption)
    {
        return objectOrOption.getFullname().equals(extractRootFullName(objectOrOption));
    }
}
