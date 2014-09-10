
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Tooltip;

public class MockTooltip
    implements Tooltip
{

    private boolean animation;
    private Number borderRadius;
    private Number borderWidth;
    private boolean enabled;
    private boolean followPointer;
    private boolean followTouchMove;
    private String footerFormat;
    private String headerFormat;
    private Number hideDelay;
    private String pointFormat;
    private boolean shadow;
    private String shape;
    private boolean shared;
    private Number snap;
    private boolean useHTML;
    private Number valueDecimals;
    private String valuePrefix;
    private String valueSuffix;
    private String xDateFormat;

    public boolean animation() {
        return animation;
    }

    public MockTooltip animation(boolean animation) {
        this.animation = animation;
        return this;
    }

    public Number borderRadius() {
        return borderRadius;
    }

    public MockTooltip borderRadius(Number borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public Number borderWidth() {
        return borderWidth;
    }

    public MockTooltip borderWidth(Number borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public boolean enabled() {
        return enabled;
    }

    public MockTooltip enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public boolean followPointer() {
        return followPointer;
    }

    public MockTooltip followPointer(boolean followPointer) {
        this.followPointer = followPointer;
        return this;
    }

    public boolean followTouchMove() {
        return followTouchMove;
    }

    public MockTooltip followTouchMove(boolean followTouchMove) {
        this.followTouchMove = followTouchMove;
        return this;
    }

    public String footerFormat() {
        return footerFormat;
    }

    public MockTooltip footerFormat(String footerFormat) {
        this.footerFormat = footerFormat;
        return this;
    }

    public String headerFormat() {
        return headerFormat;
    }

    public MockTooltip headerFormat(String headerFormat) {
        this.headerFormat = headerFormat;
        return this;
    }

    public Number hideDelay() {
        return hideDelay;
    }

    public MockTooltip hideDelay(Number hideDelay) {
        this.hideDelay = hideDelay;
        return this;
    }

    public String pointFormat() {
        return pointFormat;
    }

    public MockTooltip pointFormat(String pointFormat) {
        this.pointFormat = pointFormat;
        return this;
    }

    public boolean shadow() {
        return shadow;
    }

    public MockTooltip shadow(boolean shadow) {
        this.shadow = shadow;
        return this;
    }

    public String shape() {
        return shape;
    }

    public MockTooltip shape(String shape) {
        this.shape = shape;
        return this;
    }

    public boolean shared() {
        return shared;
    }

    public MockTooltip shared(boolean shared) {
        this.shared = shared;
        return this;
    }

    public Number snap() {
        return snap;
    }

    public MockTooltip snap(Number snap) {
        this.snap = snap;
        return this;
    }

    public boolean useHTML() {
        return useHTML;
    }

    public MockTooltip useHTML(boolean useHTML) {
        this.useHTML = useHTML;
        return this;
    }

    public Number valueDecimals() {
        return valueDecimals;
    }

    public MockTooltip valueDecimals(Number valueDecimals) {
        this.valueDecimals = valueDecimals;
        return this;
    }

    public String valuePrefix() {
        return valuePrefix;
    }

    public MockTooltip valuePrefix(String valuePrefix) {
        this.valuePrefix = valuePrefix;
        return this;
    }

    public String valueSuffix() {
        return valueSuffix;
    }

    public MockTooltip valueSuffix(String valueSuffix) {
        this.valueSuffix = valueSuffix;
        return this;
    }

    public String xDateFormat() {
        return xDateFormat;
    }

    public MockTooltip xDateFormat(String xDateFormat) {
        this.xDateFormat = xDateFormat;
        return this;
    }

}
