package com.usesoft.highcharts4gwt.generator.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

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

    public void addRelation(OptionSpec parent, List<OptionSpec> children)
    {
        relations.put(parent, children);
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
}
