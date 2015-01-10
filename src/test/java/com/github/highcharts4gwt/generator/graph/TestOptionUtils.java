package com.github.highcharts4gwt.generator.graph;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.github.highcharts4gwt.generator.common.HasFullnameUtils;
import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.generator.option.OptionUtils;

public class TestOptionUtils
{
    @Test
    public void testGetHighchartsPackageName()
    {
        // Given
        Option optionSpec = new Option("global.Date", "global--Date", "Date");

        // When
        String highchartsPackageName = HasFullnameUtils.getPackageName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("global");
    }

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
    public void testGetHighchartsPackageName2()
    {
        // Given
        Option optionSpec = new Option("plotOptions.series.events.afterAnimate", "plotOptions-series-events--afterAnimate", "afterAnimate");

        // When
        String highchartsPackageName = HasFullnameUtils.getPackageName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("plotoptions.series.events");
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
    public void testGetHighchartsPackageName3()
    {
        // Given
        Option optionSpec = new Option("chart", "chart", "chart");

        // When
        String highchartsPackageName = HasFullnameUtils.getPackageName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("");
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
    public void testIsRoot()
    {
        // Given
        Option optionSpec = new Option("chart", "chart", "chart");
        Option optionSpec2 = new Option("global.Date", "global--Date", "Date");

        // When
        boolean isRoot = HasFullnameUtils.isRoot(optionSpec);
        boolean isRoot2 = HasFullnameUtils.isRoot(optionSpec2);

        // Then
        assertThat(isRoot).isTrue();
        assertThat(isRoot2).isFalse();
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

}
