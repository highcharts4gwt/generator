package com.github.highcharts4gwt.generator.option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.HasFullnameUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * A tree of options. It contains a root and different maps and lists to be able
 * to generate the classes (from leaves to root of the tree). Leaves are fields.
 * 
 * @author rquillevere
 */
public class OptionTree
{
    private static final Logger logger = LoggerFactory.getLogger(OptionTree.class);

    public OptionTree(Option root)
    {
        this.root = root;
        this.parentToChildrenRelations = new HashMap<Option, List<Option>>();
        this.childToParentRelations = new HashMap<Option, Option>();
        this.leaves = new ArrayList<Option>();
        this.all = new ArrayList<Option>();
    }

    public Option getRoot()
    {
        return root;
    }

    @CheckForNull
    public List<Option> getChildren(Option option)
    {
        return parentToChildrenRelations.get(option);
    }

    @CheckForNull
    public Option getParent(Option option)
    {
        return childToParentRelations.get(option);
    }

    public void addParentChildren(Option option, List<Option> children)
    {
        parentToChildrenRelations.put(option, children);
    }

    public void computeAndAddRelation(Option option, List<Option> options)
    {
        all.add(option);

        setLeavesInfo(option);

        if (HasFullnameUtils.isRoot(option))
            return;

        Option parent = OptionUtils.findParent(option, options);

        if (parent == null)
            return;

        setParentChildrenInfo(option, parent);

    }

    public ArrayList<Option> getLeaves()
    {
        return leaves;
    }

    public ArrayList<Option> getAll()
    {
        return all;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("root", getRoot()).toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (obj instanceof OptionTree)
            return Objects.equal(getRoot(), ((OptionTree) obj).getRoot());
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(getRoot());
    }

    @VisibleForTesting
    public Map<Option, List<Option>> getParentToChildrenRelations()
    {
        return parentToChildrenRelations;
    }

    private void setLeavesInfo(Option option)
    {
        if (!option.isParent())
            leaves.add(option);
    }

    private void setParentChildrenInfo(Option option, Option parent)
    {
        childToParentRelations.put(option, parent);

        List<Option> children = parentToChildrenRelations.get(parent);

        if (children == null)
        {
            List<Option> list = new ArrayList<Option>();
            list.add(option);
            parentToChildrenRelations.put(parent, list);
        }
        else
            children.add(option);
    }

    private final Option root;

    private final ArrayList<Option> leaves;
    private final ArrayList<Option> all;

    private final Map<Option, List<Option>> parentToChildrenRelations;

    private final HashMap<Option, Option> childToParentRelations;

}
