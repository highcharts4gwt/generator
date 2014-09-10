
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Arearange;

public class MockArearange
    implements Arearange
{

    private Number lineWidth;
    private boolean trackByArea;

    public Number lineWidth() {
        return lineWidth;
    }

    public MockArearange lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public boolean trackByArea() {
        return trackByArea;
    }

    public MockArearange trackByArea(boolean trackByArea) {
        this.trackByArea = trackByArea;
        return this;
    }

}
