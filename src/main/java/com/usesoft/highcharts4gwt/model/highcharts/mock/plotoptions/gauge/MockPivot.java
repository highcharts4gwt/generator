
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.gauge;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.gauge.Pivot;

public class MockPivot
    implements Pivot
{

    private Number borderWidth;
    private Number radius;

    public Number borderWidth() {
        return borderWidth;
    }

    public MockPivot borderWidth(Number borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public Number radius() {
        return radius;
    }

    public MockPivot radius(Number radius) {
        this.radius = radius;
        return this;
    }

}
