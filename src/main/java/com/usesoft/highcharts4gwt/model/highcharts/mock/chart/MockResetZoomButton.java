
package com.usesoft.highcharts4gwt.model.highcharts.mock.chart;

import com.usesoft.highcharts4gwt.model.highcharts.api.chart.ResetZoomButton;

public class MockResetZoomButton
    implements ResetZoomButton
{

    private String relativeTo;

    public String relativeTo() {
        return relativeTo;
    }

    public MockResetZoomButton relativeTo(String relativeTo) {
        this.relativeTo = relativeTo;
        return this;
    }

}
