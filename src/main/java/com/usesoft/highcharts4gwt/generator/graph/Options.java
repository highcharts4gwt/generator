package com.usesoft.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.List;

import com.usesoft.highcharts4gwt.generator.jsonparser.OptionUtils;

public class Options
{
    private final List<OptionTree> trees = new ArrayList<OptionTree>();

    public List<OptionTree> getTrees()
    {
        return trees;
    }

    public void add(OptionSpec option, List<OptionSpec> options)
    {
        boolean found = false;
        String optionRootFullName = OptionUtils.extractRootFullName(option);
        for (OptionTree tree : trees)
        {
            if (tree.getRoot().getFullname().equals(optionRootFullName))
            {
                found = true;
            }
        }

        if (!found)
        {
            int rootIndex = options.indexOf(new OptionSpec(optionRootFullName, "", ""));
            trees.add(new OptionTree(options.get(rootIndex)));
        }

        // tree exist so add children

    }
}
