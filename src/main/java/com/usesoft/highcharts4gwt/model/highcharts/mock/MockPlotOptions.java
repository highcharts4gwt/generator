
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.PlotOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Area;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Areaspline;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Bar;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Line;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Pie;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Spline;

public class MockPlotOptions
    implements PlotOptions
{

    private Area area;
    private Areaspline areaspline;
    private Bar bar;
    private Line line;
    private Pie pie;
    private Series series;
    private Spline spline;

    public Area area() {
        return area;
    }

    public MockPlotOptions area(Area area) {
        this.area = area;
        return this;
    }

    public Areaspline areaspline() {
        return areaspline;
    }

    public MockPlotOptions areaspline(Areaspline areaspline) {
        this.areaspline = areaspline;
        return this;
    }

    public Bar bar() {
        return bar;
    }

    public MockPlotOptions bar(Bar bar) {
        this.bar = bar;
        return this;
    }

    public Line line() {
        return line;
    }

    public MockPlotOptions line(Line line) {
        this.line = line;
        return this;
    }

    public Pie pie() {
        return pie;
    }

    public MockPlotOptions pie(Pie pie) {
        this.pie = pie;
        return this;
    }

    public Series series() {
        return series;
    }

    public MockPlotOptions series(Series series) {
        this.series = series;
        return this;
    }

    public Spline spline() {
        return spline;
    }

    public MockPlotOptions spline(Spline spline) {
        this.spline = spline;
        return this;
    }

}
