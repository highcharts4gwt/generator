package com.usesoft.highcharts4gwt.generator.graph;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class TestOptionUtils
{
    @Test
    public void testGetHighchartsPackageName()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("global.Date", "global--Date", "Date");

        // When
        String highchartsPackageName = OptionUtils.getHighchartsPackageName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("global");
    }

    @Test
    public void testGetClassName()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("global.Date", "global--Date", "Date");

        // When
        String highchartsPackageName = OptionUtils.getClassName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("Date");
    }

    @Test
    public void testGetHighchartsPackageName2()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("plotOptions.series.events.afterAnimate", "plotOptions-series-events--afterAnimate", "afterAnimate");

        // When
        String highchartsPackageName = OptionUtils.getHighchartsPackageName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("plotoptions.series.events");
    }

    @Test
    public void testGetClassName2()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("plotOptions.series.events.afterAnimate", "plotOptions-series-events--afterAnimate", "afterAnimate");

        // When
        String highchartsPackageName = OptionUtils.getClassName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("AfterAnimate");
    }

    @Test
    public void testGetHighchartsPackageName3()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("chart", "chart", "chart");

        // When
        String highchartsPackageName = OptionUtils.getHighchartsPackageName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("");
    }

    @Test
    public void testGetClassName3()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("chart", "chart", "chart");

        // When
        String highchartsPackageName = OptionUtils.getClassName(optionSpec);

        // Then
        assertThat(highchartsPackageName).isEqualTo("Chart");
    }

    @Test
    public void testIsRoot()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("chart", "chart", "chart");
        OptionSpec optionSpec2 = new OptionSpec("global.Date", "global--Date", "Date");

        // When
        boolean isRoot = OptionUtils.isRoot(optionSpec);
        boolean isRoot2 = OptionUtils.isRoot(optionSpec2);

        // Then
        assertThat(isRoot).isTrue();
        assertThat(isRoot2).isFalse();
    }

    @Test
    public void testDepth()
    {
        // Given
        OptionSpec optionSpec = new OptionSpec("chart", "chart", "chart");
        OptionSpec optionSpec2 = new OptionSpec("global.Date", "global--Date", "Date");
        OptionSpec optionSpec3 = new OptionSpec("plotOptions.series.events.afterAnimate", "plotOptions-series-events--afterAnimate", "afterAnimate");

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
