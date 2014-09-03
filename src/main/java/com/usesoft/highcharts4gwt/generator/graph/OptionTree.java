package com.usesoft.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.usesoft.highcharts4gwt.generator.jsonparser.OptionUtils;

/**
 * A tree of options. It contains a root and a map with all the relationship between children leaves.
 * @author rquillevere
 */
public class OptionTree
{
    public OptionTree(OptionSpec root)
    {
        this.root = root;
        this.relations = new HashMap<OptionSpec, List<OptionSpec>>();
    }

    public OptionSpec getRoot()
    {
        return root;
    }

    public Map<OptionSpec, List<OptionSpec>> getRelations()
    {
        return relations;
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

    private final OptionSpec root;

    private final Map<OptionSpec, List<OptionSpec>> relations;

    public void computeAndAddRelation(OptionSpec option, List<OptionSpec> options)
    {
        if (OptionUtils.isRoot(option))
            return;

        OptionSpec parent = OptionUtils.findParent(option, options);

        if (parent == null)
            return;

        List<OptionSpec> children = relations.get(parent);

        if (children == null)
        {
            List<OptionSpec> list = new ArrayList<OptionSpec>();
            list.add(option);
            relations.put(parent, list);
        }
        else
        {
            children.add(option);
        }
    }

}
