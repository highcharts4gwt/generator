package com.usesoft.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;

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
        String optionRootFullName = OptionUtils.extractRootFullName(option);
        return findTree(optionRootFullName);
    }

    /**
     * Find the {@link OptionTree} in which this option belongs.
     * 
     * @param option
     *            an {@link Option}.
     * @return the OptionTree found or null.
     */
    @CheckForNull
    @VisibleForTesting
    OptionTree findTree(String rootFullName)
    {
        for (OptionTree tree : trees)
        {
            if (tree.getRoot().getFullname().equals(rootFullName))
                return tree;
        }

        return null;
    }

    @CheckForNull
    public Option findExtendedOption(Option option, OptionsData optionsData)
    {
        String extending = option.getExtending();
        if (Strings.isNullOrEmpty(extending))
            return null;
        String extendedFullName = OptionUtils.transformExtendsNameToFullname(extending);
        OptionTree tree = optionsData.findTree(OptionUtils.extractRootFullName(extendedFullName));
        Option extendedOption = OptionUtils.find(extendedFullName, tree.getAll());
        return extendedOption;
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
        Option root = OptionUtils.find(OptionUtils.extractRootFullName(option), options);

        if (root == null)
            throw new RuntimeException("Could not find root option");

        OptionTree tree = new OptionTree(root);
        trees.add(tree);
        return tree;
    }

}
