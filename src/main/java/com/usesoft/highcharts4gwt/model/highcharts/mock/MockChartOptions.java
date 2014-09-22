
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.Chart;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Credits;
import com.usesoft.highcharts4gwt.model.highcharts.api.Drilldown;
import com.usesoft.highcharts4gwt.model.highcharts.api.Exporting;
import com.usesoft.highcharts4gwt.model.highcharts.api.Global;
import com.usesoft.highcharts4gwt.model.highcharts.api.Labels;
import com.usesoft.highcharts4gwt.model.highcharts.api.Lang;
import com.usesoft.highcharts4gwt.model.highcharts.api.Legend;
import com.usesoft.highcharts4gwt.model.highcharts.api.Loading;
import com.usesoft.highcharts4gwt.model.highcharts.api.Navigation;
import com.usesoft.highcharts4gwt.model.highcharts.api.NoData;
import com.usesoft.highcharts4gwt.model.highcharts.api.PlotOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;
import com.usesoft.highcharts4gwt.model.highcharts.api.Subtitle;
import com.usesoft.highcharts4gwt.model.highcharts.api.Title;
import com.usesoft.highcharts4gwt.model.highcharts.api.Tooltip;
import com.usesoft.highcharts4gwt.model.highcharts.api.XAxis;
import com.usesoft.highcharts4gwt.model.highcharts.api.YAxis;

public class MockChartOptions
    implements ChartOptions
{

    private Global global;
    private Drilldown drilldown;
    private Legend legend;
    private Chart chart;
    private PlotOptions plotOptions;
    private XAxis xAxis;
    private Navigation navigation;
    private Subtitle subtitle;
    private Title title;
    private YAxis yAxis;
    private Tooltip tooltip;
    private NoData noData;
    private Exporting exporting;
    private Array<Series> series;
    private Lang lang;
    private Credits credits;
    private Loading loading;
    private Labels labels;

    public Global global() {
        return global;
    }

    public MockChartOptions global(Global global) {
        this.global = global;
        return this;
    }

    public Drilldown drilldown() {
        return drilldown;
    }

    public MockChartOptions drilldown(Drilldown drilldown) {
        this.drilldown = drilldown;
        return this;
    }

    public Legend legend() {
        return legend;
    }

    public MockChartOptions legend(Legend legend) {
        this.legend = legend;
        return this;
    }

    public Chart chart() {
        return chart;
    }

    public MockChartOptions chart(Chart chart) {
        this.chart = chart;
        return this;
    }

    public PlotOptions plotOptions() {
        return plotOptions;
    }

    public MockChartOptions plotOptions(PlotOptions plotOptions) {
        this.plotOptions = plotOptions;
        return this;
    }

    public XAxis xAxis() {
        return xAxis;
    }

    public MockChartOptions xAxis(XAxis xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public Navigation navigation() {
        return navigation;
    }

    public MockChartOptions navigation(Navigation navigation) {
        this.navigation = navigation;
        return this;
    }

    public Subtitle subtitle() {
        return subtitle;
    }

    public MockChartOptions subtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public Title title() {
        return title;
    }

    public MockChartOptions title(Title title) {
        this.title = title;
        return this;
    }

    public YAxis yAxis() {
        return yAxis;
    }

    public MockChartOptions yAxis(YAxis yAxis) {
        this.yAxis = yAxis;
        return this;
    }

    public Tooltip tooltip() {
        return tooltip;
    }

    public MockChartOptions tooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public NoData noData() {
        return noData;
    }

    public MockChartOptions noData(NoData noData) {
        this.noData = noData;
        return this;
    }

    public Exporting exporting() {
        return exporting;
    }

    public MockChartOptions exporting(Exporting exporting) {
        this.exporting = exporting;
        return this;
    }

    public Array<Series> series() {
        return series;
    }

    public MockChartOptions series(Array<Series> series) {
        this.series = series;
        return this;
    }

    public Lang lang() {
        return lang;
    }

    public MockChartOptions lang(Lang lang) {
        this.lang = lang;
        return this;
    }

    public Credits credits() {
        return credits;
    }

    public MockChartOptions credits(Credits credits) {
        this.credits = credits;
        return this;
    }

    public Loading loading() {
        return loading;
    }

    public MockChartOptions loading(Loading loading) {
        this.loading = loading;
        return this;
    }

    public Labels labels() {
        return labels;
    }

    public MockChartOptions labels(Labels labels) {
        this.labels = labels;
        return this;
    }

}
