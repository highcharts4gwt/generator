
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Title;

public class MockTitle
    implements Title
{

    private String align;
    private boolean floating;
    private Number margin;
    private String text;
    private boolean useHTML;
    private String verticalAlign;
    private Number x;
    private Number y;

    public String align() {
        return align;
    }

    public MockTitle align(String align) {
        this.align = align;
        return this;
    }

    public boolean floating() {
        return floating;
    }

    public MockTitle floating(boolean floating) {
        this.floating = floating;
        return this;
    }

    public Number margin() {
        return margin;
    }

    public MockTitle margin(Number margin) {
        this.margin = margin;
        return this;
    }

    public String text() {
        return text;
    }

    public MockTitle text(String text) {
        this.text = text;
        return this;
    }

    public boolean useHTML() {
        return useHTML;
    }

    public MockTitle useHTML(boolean useHTML) {
        this.useHTML = useHTML;
        return this;
    }

    public String verticalAlign() {
        return verticalAlign;
    }

    public MockTitle verticalAlign(String verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    public Number x() {
        return x;
    }

    public MockTitle x(Number x) {
        this.x = x;
        return this;
    }

    public Number y() {
        return y;
    }

    public MockTitle y(Number y) {
        this.y = y;
        return this;
    }

}
