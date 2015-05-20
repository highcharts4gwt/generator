package com.github.highcharts4gwt.generator.option;

import java.util.List;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.ObjectOrOptionUtils;
import com.github.highcharts4gwt.generator.common.field.FieldType;
import com.github.highcharts4gwt.generator.common.field.FieldTypeHelper;
import com.google.common.collect.Lists;

public class OptionUtils
{
    private OptionUtils()
    {
    }

    public static int depth(Option option)
    {
        String fullname = option.getFullname();
        int length = fullname.split("\\.").length;
        return length - 1;
    }

    @CheckForNull
    public static String extractParentFullName(Option option)
    {
        String fullname = option.getFullname();
        int lastIndexOf = fullname.lastIndexOf(".");

        if (lastIndexOf == -1)
            return null;

        String parentFullName = fullname.substring(0, lastIndexOf); //to support series<xxx>.child
        
        if (parentFullName.matches("\\w+<\\w+>\\.\\w+"))
            parentFullName.replaceAll("<\\w+", "");
        return parentFullName;
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

    public static String getShortClassName(Option option)
    {
        String className = ObjectOrOptionUtils.getShortClassName(option);

        FieldType fieldType = FieldTypeHelper.findTypes(option).get(0);
        if (option.isParent() && fieldType.isArray() && !className.equals("Series") && className.endsWith("s"))
            className = className.substring(0, className.length() - 1);

        return className;
    }

    public static List<OptionTree> getTreesInOrder(OptionsData optionData, String... rootsInOrder)
    {
        List<OptionTree> trees = Lists.newArrayList(optionData.getTrees());

        List<OptionTree> out = Lists.newArrayList();

        for (int i = 0; i < rootsInOrder.length; i++)
        {
            findMatchingTree(trees, out, rootsInOrder[i]);
        }

        for (OptionTree optionTree : trees)
        {
            out.add(optionTree);
        }

        return out;
    }

    private static void findMatchingTree(List<OptionTree> trees, List<OptionTree> out, String rootTitle)
    {
        for (OptionTree optionTree : trees)
        {
            if (optionTree.getRoot().getTitle().equals(rootTitle))
            {
                out.add(optionTree);
                trees.remove(optionTree);
                break;
            }

        }
    }

}
