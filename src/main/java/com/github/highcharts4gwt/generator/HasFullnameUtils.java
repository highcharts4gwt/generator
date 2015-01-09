package com.github.highcharts4gwt.generator;

public class HasFullnameUtils
{
    private HasFullnameUtils()
    {
    }

    public static String extractRootFullName(ObjectOrOption hasFullname)
    {
        String fullname = hasFullname.getFullname();
        return extractRootFullName(fullname);
    }

    public static String extractRootFullName(String fullname)
    {
        return fullname.split("\\.")[0];
    }

    public static String getShortClassName(ObjectOrOption hasFullName)
    {
        String fullName = hasFullName.getFullname();
        int index = fullName.lastIndexOf(".");
        String scn = fullName.substring(index + 1, index + 2).toUpperCase() + fullName.substring(index + 2);
        return scn;
    }

    public static String getPackageName(ObjectOrOption hasFullName)
    {
        String fullName = hasFullName.getFullname();
        int index = fullName.lastIndexOf(".");
        if (index != -1)
            return fullName.substring(0, index).toLowerCase();
        return "";
    }

    public static String computePackageName(ObjectOrOption hasFullname, OutputType outputType, String objectOrOptionPackage)
    {
        String pckg = objectOrOptionPackage + "." + outputType.getPackageName();
        String packageName = HasFullnameUtils.getPackageName(hasFullname);
        if (!packageName.equalsIgnoreCase(""))
        {
            pckg += "." + packageName;
        }
        return pckg;
    }

    public static boolean isRoot(ObjectOrOption hasFullname)
    {
        return hasFullname.getFullname().equals(extractRootFullName(hasFullname));
    }
}
