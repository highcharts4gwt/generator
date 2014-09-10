
package com.usesoft.highcharts4gwt.model.highcharts.mock.yaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Labels;

public class MockLabels
    implements Labels
{

    private String align;
    private Number distance;
    private Number x;
    private Number y;

    public String align() {
        return align;
    }

    public MockLabels align(String align) {
        this.align = align;
        return this;
    }

    public Number distance() {
        return distance;
    }

    public MockLabels distance(Number distance) {
        this.distance = distance;
        return this;
    }

    public Number x() {
        return x;
    }

    public MockLabels x(Number x) {
        this.x = x;
        return this;
    }

    public Number y() {
        return y;
    }

    public MockLabels y(Number y) {
        this.y = y;
        return this;
    }

}
