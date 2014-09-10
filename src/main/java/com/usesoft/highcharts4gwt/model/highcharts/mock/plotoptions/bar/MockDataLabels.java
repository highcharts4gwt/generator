
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.bar;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bar.DataLabels;

public class MockDataLabels
    implements DataLabels
{

    private String align;
    private Number x;

    public String align() {
        return align;
    }

    public MockDataLabels align(String align) {
        this.align = align;
        return this;
    }

    public Number x() {
        return x;
    }

    public MockDataLabels x(Number x) {
        this.x = x;
        return this;
    }

}
