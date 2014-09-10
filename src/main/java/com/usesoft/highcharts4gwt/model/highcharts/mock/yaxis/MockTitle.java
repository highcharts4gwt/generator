
package com.usesoft.highcharts4gwt.model.highcharts.mock.yaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Title;

public class MockTitle
    implements Title
{

    private Number margin;
    private Number rotation;
    private String text;

    public Number margin() {
        return margin;
    }

    public MockTitle margin(Number margin) {
        this.margin = margin;
        return this;
    }

    public Number rotation() {
        return rotation;
    }

    public MockTitle rotation(Number rotation) {
        this.rotation = rotation;
        return this;
    }

    public String text() {
        return text;
    }

    public MockTitle text(String text) {
        this.text = text;
        return this;
    }

}
