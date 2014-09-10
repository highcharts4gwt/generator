
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Scatter;

public class MockScatter
    implements Scatter
{

    private Number lineWidth;
    private boolean stickyTracking;

    public Number lineWidth() {
        return lineWidth;
    }

    public MockScatter lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public boolean stickyTracking() {
        return stickyTracking;
    }

    public MockScatter stickyTracking(boolean stickyTracking) {
        this.stickyTracking = stickyTracking;
        return this;
    }

}
