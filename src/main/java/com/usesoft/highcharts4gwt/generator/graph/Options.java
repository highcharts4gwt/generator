package com.usesoft.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;


/**
 * Contains all the OptionTrees.
 * @author rquillevere
 */
public class Options
{
    private final List<OptionTree> trees = new ArrayList<OptionTree>();

    public List<OptionTree> getTrees()
    {
        return trees;
    }

    public void add(OptionSpec option, List<OptionSpec> options)
    {
        OptionTree tree = findTree(option);

        if (tree == null)
            tree = addNewTree(option, options);

        tree.computeAndAddRelation(option, options);

    }

    /**
     * Create an {@link OptionTree} with the root initialized. Add it to the tree list.
     * @param option
     *        An {@link OptionSpec} that should belong to that tree. From its fullname we will discover the root fullname.
     * @param options
     *        The list of all {@link OptionSpec}, needed to find the real root of the option tree based on its fullname.
     * @return
     */
    private OptionTree addNewTree(OptionSpec option, List<OptionSpec> options)
    {
        OptionSpec root = OptionUtils.find(options, OptionUtils.extractRootFullName(option));

        if (root == null)
            throw new RuntimeException("Could not find root option");

        OptionTree tree = new OptionTree(root);
        trees.add(tree);
        return tree;
    }

    /**
     * Find the {@link OptionTree} in which this option belongs.
     * @param option
     *        an {@link OptionSpec}.
     * @return the OptionTree found or null.
     */
    @CheckForNull
    public OptionTree findTree(OptionSpec option)
    {
        String optionRootFullName = OptionUtils.extractRootFullName(option);
        return findTree(optionRootFullName);
    }

    /**
     * Find the {@link OptionTree} in which this option belongs.
     * @param option
     *        an {@link OptionSpec}.
     * @return the OptionTree found or null.
     */
    @CheckForNull
    public OptionTree findTree(String optionFullName)
    {
        for (OptionTree tree : trees)
        {
            if (tree.getRoot().getFullname().equals(optionFullName))
                return tree;
        }

        return null;
    }

}
