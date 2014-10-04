
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.bar.states;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bar.states.Hover;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bar.states.hover.Marker;

public class MockHover
    implements Hover
{

    private boolean enabled;
    private Number lineWidth;
    private Number lineWidthPlus;
    private Marker marker;

    public boolean enabled() {
        return enabled;
    }

    public MockHover enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Number lineWidth() {
        return lineWidth;
    }

    public MockHover lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public Number lineWidthPlus() {
        return lineWidthPlus;
    }

    public MockHover lineWidthPlus(Number lineWidthPlus) {
        this.lineWidthPlus = lineWidthPlus;
        return this;
    }

    public Marker marker() {
        return marker;
    }

    public MockHover marker(Marker marker) {
        this.marker = marker;
        return this;
    }

}
