
package com.usesoft.highcharts4gwt.model.highcharts.mock.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Title;

public class MockTitle
    implements Title
{

    private String align;
    private String enabled;
    private Number margin;
    private Number offset;
    private Number rotation;
    private String text;

    public String align() {
        return align;
    }

    public MockTitle align(String align) {
        this.align = align;
        return this;
    }

    public String enabled() {
        return enabled;
    }

    public MockTitle enabled(String enabled) {
        this.enabled = enabled;
        return this;
    }

    public Number margin() {
        return margin;
    }

    public MockTitle margin(Number margin) {
        this.margin = margin;
        return this;
    }

    public Number offset() {
        return offset;
    }

    public MockTitle offset(Number offset) {
        this.offset = offset;
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
