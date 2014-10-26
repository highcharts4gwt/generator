package com.usesoft.highcharts4gwt.generator.graph;

import java.util.List;

import javax.annotation.CheckForNull;

import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldType;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldTypeHelper;

public class OptionUtils
{
    private OptionUtils()
    {
    }

    public static boolean isRoot(Option option)
    {
        return option.getFullname().equals(extractRootFullName(option));
    }

    public static int depth(Option option)
    {
        String fullname = option.getFullname();
        int length = fullname.split("\\.").length;
        return length - 1;
    }

    public static String extractRootFullName(Option option)
    {
        String optionFullName = option.getFullname();
        return extractRootFullName(optionFullName);
    }

    public static String extractRootFullName(String optionFullName)
    {
        return optionFullName.split("\\.")[0];
    }

    @CheckForNull
    public static String extractParentFullName(Option option)
    {
        String fullname = option.getFullname();
        int lastIndexOf = fullname.lastIndexOf(".");

        if (lastIndexOf == -1)
            return null;

        String parentFullName = fullname.substring(0, lastIndexOf);
        return parentFullName;
    }

    public static String transformExtendsNameToFullname(String nameWithDash)
    {
        String out = nameWithDash.replace("--", ".");
        out = nameWithDash.replace("-", ".");
        return out;
    }

    @CheckForNull
    public static Option find(String optionFullName, List<Option> options)
    {
        int index = options.indexOf(new Option(optionFullName, "", ""));

        if (index == -1)
            return null;

        return options.get(index);
    }

    @CheckForNull
    public static Option findParent(Option option, List<Option> options)
    {
        String parentFullName = OptionUtils.extractParentFullName(option);

        if (parentFullName == null)
            return null;

        Option parent = OptionUtils.find(parentFullName, options);
        return parent;
    }

    public static String getClassName(Option option)
    {
        String fullName = option.getFullname();
        int index = fullName.lastIndexOf(".");
        String className = fullName.substring(index + 1, index + 2).toUpperCase() + fullName.substring(index + 2);

        FieldType fieldType = FieldTypeHelper.findTypes(option).get(0);
        if (option.isParent() && fieldType.isArray() && !className.equals("Series") && className.endsWith("s"))
            className = className.substring(0, className.length() - 1);

        return className;
    }

    public static String getHighchartsPackageName(Option optionSpec)
    {
        String fullName = optionSpec.getFullname();
        int index = fullName.lastIndexOf(".");
        if (index != -1)
            return fullName.substring(0, index).toLowerCase();
        return "";
    }

}
