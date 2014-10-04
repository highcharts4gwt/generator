
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Column;
import com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.MockSeries;

public class MockColumn
    extends MockSeries
    implements Column
{

    private Number borderRadius;
    private Number borderWidth;
    private boolean colorByPoint;
    private Number depth;
    private Number edgeWidth;
    private Number groupPadding;
    private Number groupZPadding;
    private boolean grouping;
    private Number minPointLength;
    private Number pointPadding;
    private Number pointRange;
    private Number pointWidth;

    public Number borderRadius() {
        return borderRadius;
    }

    public MockColumn borderRadius(Number borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public Number borderWidth() {
        return borderWidth;
    }

    public MockColumn borderWidth(Number borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public boolean colorByPoint() {
        return colorByPoint;
    }

    public MockColumn colorByPoint(boolean colorByPoint) {
        this.colorByPoint = colorByPoint;
        return this;
    }

    public Number depth() {
        return depth;
    }

    public MockColumn depth(Number depth) {
        this.depth = depth;
        return this;
    }

    public Number edgeWidth() {
        return edgeWidth;
    }

    public MockColumn edgeWidth(Number edgeWidth) {
        this.edgeWidth = edgeWidth;
        return this;
    }

    public Number groupPadding() {
        return groupPadding;
    }

    public MockColumn groupPadding(Number groupPadding) {
        this.groupPadding = groupPadding;
        return this;
    }

    public Number groupZPadding() {
        return groupZPadding;
    }

    public MockColumn groupZPadding(Number groupZPadding) {
        this.groupZPadding = groupZPadding;
        return this;
    }

    public boolean grouping() {
        return grouping;
    }

    public MockColumn grouping(boolean grouping) {
        this.grouping = grouping;
        return this;
    }

    public Number minPointLength() {
        return minPointLength;
    }

    public MockColumn minPointLength(Number minPointLength) {
        this.minPointLength = minPointLength;
        return this;
    }

    public Number pointPadding() {
        return pointPadding;
    }

    public MockColumn pointPadding(Number pointPadding) {
        this.pointPadding = pointPadding;
        return this;
    }

    public Number pointRange() {
        return pointRange;
    }

    public MockColumn pointRange(Number pointRange) {
        this.pointRange = pointRange;
        return this;
    }

    public Number pointWidth() {
        return pointWidth;
    }

    public MockColumn pointWidth(Number pointWidth) {
        this.pointWidth = pointWidth;
        return this;
    }

}
