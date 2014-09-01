package com.usesoft.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphMultiRoot
{
    private List<Graph> graphs = new ArrayList<Graph>();

    public List<Graph> getGraphs()
    {
        return graphs;
    }

    public void setRoots(List<Graph> graphs)
    {
        this.graphs = graphs;
    }
}
