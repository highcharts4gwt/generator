package com.github.highcharts4gwt.generator.graph;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.OptionTree;
import com.github.highcharts4gwt.generator.option.OptionUtils;
import com.github.highcharts4gwt.generator.option.OptionsData;
import com.google.common.collect.Lists;

public class TestOptionUtils
{
    @Test
    public void testGetClassName()
    {
        // Given
        Option optionSpec = new Option("global.Date", "global--Date", "Date");

        // When
        String highchartsPackageName = OptionUtils.getShortClassName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("Date");
    }

    @Test
    public void testGetClassName2()
    {
        // Given
        Option optionSpec = new Option("plotOptions.series.events.afterAnimate", "plotOptions-series-events--afterAnimate", "afterAnimate");

        // When
        String highchartsPackageName = OptionUtils.getShortClassName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("AfterAnimate");
    }

    @Test
    public void testGetClassName3()
    {
        // Given
        Option optionSpec = new Option("chart", "chart", "chart");

        // When
        String highchartsPackageName = OptionUtils.getShortClassName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("Chart");
    }

    @Test
    public void testDepth()
    {
        // Given
        Option optionSpec = new Option("chart", "chart", "chart");
        Option optionSpec2 = new Option("global.Date", "global--Date", "Date");
        Option optionSpec3 = new Option("plotOptions.series.events.afterAnimate", "plotOptions-series-events--afterAnimate", "afterAnimate");

        // When
        int depth1 = OptionUtils.depth(optionSpec);
        int depth2 = OptionUtils.depth(optionSpec2);
        int depth3 = OptionUtils.depth(optionSpec3);

        // Then
        assertThat(depth1).isEqualTo(0);
        assertThat(depth2).isEqualTo(1);
        assertThat(depth3).isEqualTo(3);
    }

    @Test
    public void testGetTreesInOrder()
    {
        // Given
        OptionsData optionData = new OptionsData();

        List<Option> all = Lists.newArrayList();

        Option root1 = new Option("root1", "root1", "root1");
        Option son1 = new Option("root1.son1", "root1--son1", "son1");
        all.add(root1);
        all.add(son1);

        Option root2 = new Option("root2", "root2", "root2");
        Option son2 = new Option("root2.son1", "root2--son1", "son1");
        all.add(root2);
        all.add(son2);

        Option root3 = new Option("root3", "root3", "root3");
        Option son3 = new Option("root3.son1", "root3--son1", "son1");
        all.add(root3);
        all.add(son3);

        optionData.add(root1, all);
        optionData.add(son1, all);
        optionData.add(root2, all);
        optionData.add(son2, all);
        optionData.add(root3, all);
        optionData.add(son3, all);

        // When
        List<OptionTree> treesInOrder = OptionUtils.getTreesInOrder(optionData, "root2", "root1");

        // Then
        assertThat(treesInOrder.size()).isEqualTo(3);
        assertThat(treesInOrder.get(0).getRoot()).isEqualTo(root2);
        assertThat(treesInOrder.get(1).getRoot()).isEqualTo(root1);
        assertThat(treesInOrder.get(2).getRoot()).isEqualTo(root3);
    }
}
