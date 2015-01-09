package com.github.highcharts4gwt.generator.option;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.HasFullnameUtils;
import com.google.common.annotations.VisibleForTesting;

/**
 * Contains all the OptionTrees.
 * 
 * @author rquillevere
 */
public class OptionsData
{
    private final List<OptionTree> trees = new ArrayList<OptionTree>();

    public List<OptionTree> getTrees()
    {
        return trees;
    }

    public void add(Option option, List<Option> allOptions)
    {
        OptionTree tree = findTree(option);

        if (tree == null)
            tree = createEmptyTree(option, allOptions);

        tree.computeAndAddRelation(option, allOptions);

    }

    /**
     * Find the {@link OptionTree} in which this option belongs.
     * 
     * @param option
     *            an {@link Option}.
     * @return the OptionTree found or null.
     */
    @CheckForNull
    public OptionTree findTree(Option option)
    {
        String optionRootFullName = HasFullnameUtils.extractRootFullName(option);
        return findTreeWithRootFullName(optionRootFullName);
    }

    /**
     * Find the {@link OptionTree} whose root has the given rootFullName.
     * 
     * @param option
     *            an {@link Option}.
     * @return the OptionTree found or null.
     */
    @CheckForNull
    @VisibleForTesting
    public OptionTree findTreeWithRootFullName(String rootFullName)
    {
        for (OptionTree tree : trees)
        {
            if (tree.getRoot().getFullname().equals(rootFullName))
                return tree;
        }

        return null;
    }

    /**
     * Create an {@link OptionTree} with the root initialized. Add it to the
     * tree list.
     * 
     * @param option
     *            An {@link Option} that should belong to that tree. From its
     *            fullname we will discover the root fullname.
     * @param options
     *            The list of all {@link Option}, needed to find the real root
     *            of the option tree based on its fullname.
     * @return
     */
    private OptionTree createEmptyTree(Option option, List<Option> options)
    {
        Option root = OptionUtils.find(HasFullnameUtils.extractRootFullName(option), options);

        if (root == null)
            throw new RuntimeException("Could not find root option");

        OptionTree tree = new OptionTree(root);
        trees.add(tree);
        return tree;
    }

}
