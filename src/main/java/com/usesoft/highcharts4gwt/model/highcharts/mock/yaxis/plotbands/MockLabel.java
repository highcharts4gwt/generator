
package com.usesoft.highcharts4gwt.model.highcharts.mock.yaxis.plotbands;

import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.plotbands.Label;

public class MockLabel
    implements Label
{

    private String align;
    private Number rotation;
    private String text;
    private String textAlign;
    private boolean useHTML;
    private String verticalAlign;
    private Number x;
    private Number y;

    public String align() {
        return align;
    }

    public MockLabel align(String align) {
        this.align = align;
        return this;
    }

    public Number rotation() {
        return rotation;
    }

    public MockLabel rotation(Number rotation) {
        this.rotation = rotation;
        return this;
    }

    public String text() {
        return text;
    }

    public MockLabel text(String text) {
        this.text = text;
        return this;
    }

    public String textAlign() {
        return textAlign;
    }

    public MockLabel textAlign(String textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    public boolean useHTML() {
        return useHTML;
    }

    public MockLabel useHTML(boolean useHTML) {
        this.useHTML = useHTML;
        return this;
    }

    public String verticalAlign() {
        return verticalAlign;
    }

    public MockLabel verticalAlign(String verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    public Number x() {
        return x;
    }

    public MockLabel x(Number x) {
        this.x = x;
        return this;
    }

    public Number y() {
        return y;
    }

    public MockLabel y(Number y) {
        this.y = y;
        return this;
    }

}
