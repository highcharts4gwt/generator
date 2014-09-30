
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.YAxis;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Events;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Labels;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.PlotBand;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.PlotLine;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.StackLabels;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Title;

public class MockYAxis
    implements YAxis
{

    private boolean endOnTick;
    private Events events;
    private String gridLineInterpolation;
    private Number gridLineWidth;
    private Labels labels;
    private Number lineWidth;
    private Number maxPadding;
    private Number minPadding;
    private Array<PlotBand> plotBands;
    private Array<PlotLine> plotLines;
    private boolean reversedStacks;
    private boolean showLastLabel;
    private StackLabels stackLabels;
    private boolean startOnTick;
    private Number tickWidth;
    private Title title;

    public boolean endOnTick() {
        return endOnTick;
    }

    public MockYAxis endOnTick(boolean endOnTick) {
        this.endOnTick = endOnTick;
        return this;
    }

    public Events events() {
        return events;
    }

    public MockYAxis events(Events events) {
        this.events = events;
        return this;
    }

    public String gridLineInterpolation() {
        return gridLineInterpolation;
    }

    public MockYAxis gridLineInterpolation(String gridLineInterpolation) {
        this.gridLineInterpolation = gridLineInterpolation;
        return this;
    }

    public Number gridLineWidth() {
        return gridLineWidth;
    }

    public MockYAxis gridLineWidth(Number gridLineWidth) {
        this.gridLineWidth = gridLineWidth;
        return this;
    }

    public Labels labels() {
        return labels;
    }

    public MockYAxis labels(Labels labels) {
        this.labels = labels;
        return this;
    }

    public Number lineWidth() {
        return lineWidth;
    }

    public MockYAxis lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public Number maxPadding() {
        return maxPadding;
    }

    public MockYAxis maxPadding(Number maxPadding) {
        this.maxPadding = maxPadding;
        return this;
    }

    public Number minPadding() {
        return minPadding;
    }

    public MockYAxis minPadding(Number minPadding) {
        this.minPadding = minPadding;
        return this;
    }

    public Array<PlotBand> plotBands() {
        return plotBands;
    }

    public MockYAxis plotBands(Array<PlotBand> plotBands) {
        this.plotBands = plotBands;
        return this;
    }

    public Array<PlotLine> plotLines() {
        return plotLines;
    }

    public MockYAxis plotLines(Array<PlotLine> plotLines) {
        this.plotLines = plotLines;
        return this;
    }

    public boolean reversedStacks() {
        return reversedStacks;
    }

    public MockYAxis reversedStacks(boolean reversedStacks) {
        this.reversedStacks = reversedStacks;
        return this;
    }

    public boolean showLastLabel() {
        return showLastLabel;
    }

    public MockYAxis showLastLabel(boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
        return this;
    }

    public StackLabels stackLabels() {
        return stackLabels;
    }

    public MockYAxis stackLabels(StackLabels stackLabels) {
        this.stackLabels = stackLabels;
        return this;
    }

    public boolean startOnTick() {
        return startOnTick;
    }

    public MockYAxis startOnTick(boolean startOnTick) {
        this.startOnTick = startOnTick;
        return this;
    }

    public Number tickWidth() {
        return tickWidth;
    }

    public MockYAxis tickWidth(Number tickWidth) {
        this.tickWidth = tickWidth;
        return this;
    }

    public Title title() {
        return title;
    }

    public MockYAxis title(Title title) {
        this.title = title;
        return this;
    }

}
