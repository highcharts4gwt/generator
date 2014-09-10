
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.arearange;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.arearange.DataLabels;

public class MockDataLabels
    implements DataLabels
{

    private Number xHigh;
    private Number xLow;
    private Number yHigh;
    private Number yLow;

    public Number xHigh() {
        return xHigh;
    }

    public MockDataLabels xHigh(Number xHigh) {
        this.xHigh = xHigh;
        return this;
    }

    public Number xLow() {
        return xLow;
    }

    public MockDataLabels xLow(Number xLow) {
        this.xLow = xLow;
        return this;
    }

    public Number yHigh() {
        return yHigh;
    }

    public MockDataLabels yHigh(Number yHigh) {
        this.yHigh = yHigh;
        return this;
    }

    public Number yLow() {
        return yLow;
    }

    public MockDataLabels yLow(Number yLow) {
        this.yLow = yLow;
        return this;
    }

}
