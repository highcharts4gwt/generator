
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Pane;

public class MockPane
    implements Pane
{

    private Number endAngle;
    private Number startAngle;

    public Number endAngle() {
        return endAngle;
    }

    public MockPane endAngle(Number endAngle) {
        this.endAngle = endAngle;
        return this;
    }

    public Number startAngle() {
        return startAngle;
    }

    public MockPane startAngle(Number startAngle) {
        this.startAngle = startAngle;
        return this;
    }

}
