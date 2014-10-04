
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Area;
import com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.MockSeries;

public class MockArea
    extends MockSeries
    implements Area
{

    private Number fillOpacity;
    private boolean trackByArea;

    public Number fillOpacity() {
        return fillOpacity;
    }

    public MockArea fillOpacity(Number fillOpacity) {
        this.fillOpacity = fillOpacity;
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
