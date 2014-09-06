package com.usesoft.highcharts4gwt.generator.jsonparser;

import java.util.List;

import javax.annotation.CheckForNull;

import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public class OptionUtils
{
    private OptionUtils()
    {
    }

    public static boolean isRoot(OptionSpec option)
    {
        return option.getFullname().equals(extractRootFullName(option));
    }

    public static String extractRootFullName(OptionSpec option)
    {
        String optionFullName = option.getFullname();
        return extractRootFullName(optionFullName);
    }

    public static String extractRootFullName(String optionFullName)
    {
        return optionFullName.split("\\.")[0];
    }

    @CheckForNull
    public static String extractParentFullName(OptionSpec option)
    {
        String fullname = option.getFullname();
        int lastIndexOf = fullname.lastIndexOf(".");

        if (lastIndexOf == -1)
            return null;

        String parentFullName = fullname.substring(0, lastIndexOf);
        return parentFullName;
    }

    @CheckForNull
    public static OptionSpec find(List<OptionSpec> options,
            String optionFullName)
    {
        int index = options.indexOf(new OptionSpec(optionFullName, "", ""));

        if (index == -1)
            return null;

        return options.get(index);
    }

    @CheckForNull
    public static OptionSpec findParent(OptionSpec option,
            List<OptionSpec> options)
    {
        String parentFullName = OptionUtils.extractParentFullName(option);

        if (parentFullName == null)
            return null;

        OptionSpec parent = OptionUtils.find(options, parentFullName);
        return parent;
    }

    public static String getFullyQualifiedName(OptionSpec optionSpec)
    {
        String fullName = optionSpec.getFullname();
        int index = fullName.lastIndexOf(".");
        String className = fullName.substring(index + 1, index + 2)
                .toUpperCase() + fullName.substring(index + 2);
        String fullyQualifiedName = fullName.substring(0, index + 1)
                + className;
        return fullyQualifiedName;
    }

    public static String getClassName(OptionSpec optionSpec)
    {
        String fullName = optionSpec.getFullname();
        int index = fullName.lastIndexOf(".");
        String className = fullName.substring(index + 1, index + 2)
                .toUpperCase() + fullName.substring(index + 2);
        return className;
    }

}
