
package com.usesoft.highcharts4gwt.model.highcharts.mock.chart.options3d.frame;

import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.frame.Bottom;

public class MockBottom
    implements Bottom
{

    private Number size;

    public Number size() {
        return size;
    }

    public MockBottom size(Number size) {
        this.size = size;
        return this;
    }

}
