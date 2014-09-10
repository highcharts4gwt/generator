
package com.usesoft.highcharts4gwt.model.highcharts.mock.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Labels;

public class MockLabels
    implements Labels
{

    private String align;
    private Number distance;
    private boolean enabled;
    private String format;
    private Number maxStaggerLines;
    private String overflow;
    private Number rotation;
    private Number staggerLines;
    private Number step;
    private boolean useHTML;
    private Number x;
    private Number y;
    private Number zIndex;

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

    public boolean enabled() {
        return enabled;
    }

    public MockLabels enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String format() {
        return format;
    }

    public MockLabels format(String format) {
        this.format = format;
        return this;
    }

    public Number maxStaggerLines() {
        return maxStaggerLines;
    }

    public MockLabels maxStaggerLines(Number maxStaggerLines) {
        this.maxStaggerLines = maxStaggerLines;
        return this;
    }

    public String overflow() {
        return overflow;
    }

    public MockLabels overflow(String overflow) {
        this.overflow = overflow;
        return this;
    }

    public Number rotation() {
        return rotation;
    }

    public MockLabels rotation(Number rotation) {
        this.rotation = rotation;
        return this;
    }

    public Number staggerLines() {
        return staggerLines;
    }

    public MockLabels staggerLines(Number staggerLines) {
        this.staggerLines = staggerLines;
        return this;
    }

    public Number step() {
        return step;
    }

    public MockLabels step(Number step) {
        this.step = step;
        return this;
    }

    public boolean useHTML() {
        return useHTML;
    }

    public MockLabels useHTML(boolean useHTML) {
        this.useHTML = useHTML;
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

    public Number zIndex() {
        return zIndex;
    }

    public MockLabels zIndex(Number zIndex) {
        this.zIndex = zIndex;
        return this;
    }

}
