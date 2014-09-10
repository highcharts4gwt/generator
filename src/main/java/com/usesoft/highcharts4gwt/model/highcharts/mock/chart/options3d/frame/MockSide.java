
package com.usesoft.highcharts4gwt.model.highcharts.mock.chart.options3d.frame;

import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.frame.Side;

public class MockSide
    implements Side
{

    private Number size;

    public Number size() {
        return size;
    }

    public MockSide size(Number size) {
        this.size = size;
        return this;
    }

}
