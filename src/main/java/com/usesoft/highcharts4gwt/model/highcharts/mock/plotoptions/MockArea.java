
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Area;

public class MockArea
    implements Area
{

    private Number fillOpacity;
    private Number threshold;
    private boolean trackByArea;

    public Number fillOpacity() {
        return fillOpacity;
    }

    public MockArea fillOpacity(Number fillOpacity) {
        this.fillOpacity = fillOpacity;
        return this;
    }

    public Number threshold() {
        return threshold;
    }

    public MockArea threshold(Number threshold) {
        this.threshold = threshold;
        return this;
    }

    public boolean trackByArea() {
        return trackByArea;
    }

    public MockArea trackByArea(boolean trackByArea) {
        this.trackByArea = trackByArea;
        return this;
    }

}
