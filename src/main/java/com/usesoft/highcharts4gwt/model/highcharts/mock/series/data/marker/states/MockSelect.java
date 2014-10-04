
package com.usesoft.highcharts4gwt.model.highcharts.mock.series.data.marker.states;

import com.usesoft.highcharts4gwt.model.highcharts.api.series.data.marker.states.Select;

public class MockSelect
    implements Select
{

    private boolean enabled;
    private Number lineWidth;
    private Number radius;

    public boolean enabled() {
        return enabled;
    }

    public MockSelect enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Number lineWidth() {
        return lineWidth;
    }

    public MockSelect lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public Number radius() {
        return radius;
    }

    public MockSelect radius(Number radius) {
        this.radius = radius;
        return this;
    }

}
