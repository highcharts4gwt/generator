
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.DataLabels;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.Events;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.Marker;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.Point;

public class MockSeries
    implements Series
{

    private boolean allowPointSelect;
    private boolean animation;
    private boolean connectEnds;
    private boolean connectNulls;
    private Number cropThreshold;
    private String cursor;
    private String dashStyle;
    private DataLabels dataLabels;
    private boolean enableMouseTracking;
    private Events events;
    private Number lineWidth;
    private String linkedTo;
    private Marker marker;
    private Point point;
    private Number pointInterval;
    private String pointPlacement;
    private Number pointStart;
    private boolean selected;
    private boolean showCheckbox;
    private boolean showInLegend;
    private String stacking;
    private boolean stickyTracking;
    private Number threshold;
    private Number turboThreshold;
    private boolean visible;

    public boolean allowPointSelect() {
        return allowPointSelect;
    }

    public MockSeries allowPointSelect(boolean allowPointSelect) {
        this.allowPointSelect = allowPointSelect;
        return this;
    }

    public boolean animation() {
        return animation;
    }

    public MockSeries animation(boolean animation) {
        this.animation = animation;
        return this;
    }

    public boolean connectEnds() {
        return connectEnds;
    }

    public MockSeries connectEnds(boolean connectEnds) {
        this.connectEnds = connectEnds;
        return this;
    }

    public boolean connectNulls() {
        return connectNulls;
    }

    public MockSeries connectNulls(boolean connectNulls) {
        this.connectNulls = connectNulls;
        return this;
    }

    public Number cropThreshold() {
        return cropThreshold;
    }

    public MockSeries cropThreshold(Number cropThreshold) {
        this.cropThreshold = cropThreshold;
        return this;
    }

    public String cursor() {
        return cursor;
    }

    public MockSeries cursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    public String dashStyle() {
        return dashStyle;
    }

    public MockSeries dashStyle(String dashStyle) {
        this.dashStyle = dashStyle;
        return this;
    }

    public DataLabels dataLabels() {
        return dataLabels;
    }

    public MockSeries dataLabels(DataLabels dataLabels) {
        this.dataLabels = dataLabels;
        return this;
    }

    public boolean enableMouseTracking() {
        return enableMouseTracking;
    }

    public MockSeries enableMouseTracking(boolean enableMouseTracking) {
        this.enableMouseTracking = enableMouseTracking;
        return this;
    }

    public Events events() {
        return events;
    }

    public MockSeries events(Events events) {
        this.events = events;
        return this;
    }

    public Number lineWidth() {
        return lineWidth;
    }

    public MockSeries lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public String linkedTo() {
        return linkedTo;
    }

    public MockSeries linkedTo(String linkedTo) {
        this.linkedTo = linkedTo;
        return this;
    }

    public Marker marker() {
        return marker;
    }

    public MockSeries marker(Marker marker) {
        this.marker = marker;
        return this;
    }

    public Point point() {
        return point;
    }

    public MockSeries point(Point point) {
        this.point = point;
        return this;
    }

    public Number pointInterval() {
        return pointInterval;
    }

    public MockSeries pointInterval(Number pointInterval) {
        this.pointInterval = pointInterval;
        return this;
    }

    public String pointPlacement() {
        return pointPlacement;
    }

    public MockSeries pointPlacement(String pointPlacement) {
        this.pointPlacement = pointPlacement;
        return this;
    }

    public Number pointStart() {
        return pointStart;
    }

    public MockSeries pointStart(Number pointStart) {
        this.pointStart = pointStart;
        return this;
    }

    public boolean selected() {
        return selected;
    }

    public MockSeries selected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public boolean showCheckbox() {
        return showCheckbox;
    }

    public MockSeries showCheckbox(boolean showCheckbox) {
        this.showCheckbox = showCheckbox;
        return this;
    }

    public boolean showInLegend() {
        return showInLegend;
    }

    public MockSeries showInLegend(boolean showInLegend) {
        this.showInLegend = showInLegend;
        return this;
    }

    public String stacking() {
        return stacking;
    }

    public MockSeries stacking(String stacking) {
        this.stacking = stacking;
        return this;
    }

    public boolean stickyTracking() {
        return stickyTracking;
    }

    public MockSeries stickyTracking(boolean stickyTracking) {
        this.stickyTracking = stickyTracking;
        return this;
    }

    public Number threshold() {
        return threshold;
    }

    public MockSeries threshold(Number threshold) {
        this.threshold = threshold;
        return this;
    }

    public Number turboThreshold() {
        return turboThreshold;
    }

    public MockSeries turboThreshold(Number turboThreshold) {
        this.turboThreshold = turboThreshold;
        return this;
    }

    public boolean visible() {
        return visible;
    }

    public MockSeries visible(boolean visible) {
        this.visible = visible;
        return this;
    }

}
