
package com.usesoft.highcharts4gwt.model.highcharts.mock.chart.options3d.frame;

import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.frame.Back;

public class MockBack
    implements Back
{

    private Number size;

    public Number size() {
        return size;
    }

    public MockBack size(Number size) {
        this.size = size;
        return this;
    }

}
