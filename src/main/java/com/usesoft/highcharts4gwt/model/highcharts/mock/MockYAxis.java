
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.YAxis;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.StackLabels;
import com.usesoft.highcharts4gwt.model.highcharts.mock.MockXAxis;

public class MockYAxis
    extends MockXAxis
    implements YAxis
{

    private String gridLineInterpolation;
    private boolean reversedStacks;
    private StackLabels stackLabels;

    public String gridLineInterpolation() {
        return gridLineInterpolation;
    }

    public MockYAxis gridLineInterpolation(String gridLineInterpolation) {
        this.gridLineInterpolation = gridLineInterpolation;
        return this;
    }

    public boolean reversedStacks() {
        return reversedStacks;
    }

    public MockYAxis reversedStacks(boolean reversedStacks) {
        this.reversedStacks = reversedStacks;
        return this;
    }

    public StackLabels stackLabels() {
        return stackLabels;
    }

    public MockYAxis stackLabels(StackLabels stackLabels) {
        this.stackLabels = stackLabels;
        return this;
    }

}
