
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
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

public class JsoChartOptions
    extends JavaScriptObject
    implements ChartOptions
{


    protected JsoChartOptions() {
    }

    public final native Global global()
        throws RuntimeException /*-{
        return this["global"] = (this["global"] || {});
    }-*/
    ;

    public final native JsoChartOptions global(Global global)
        throws RuntimeException /*-{
        this["global"] = global;
        return this;
    }-*/
    ;

    public final native Drilldown drilldown()
        throws RuntimeException /*-{
        return this["drilldown"] = (this["drilldown"] || {});
    }-*/
    ;

    public final native JsoChartOptions drilldown(Drilldown drilldown)
        throws RuntimeException /*-{
        this["drilldown"] = drilldown;
        return this;
    }-*/
    ;

    public final native Legend legend()
        throws RuntimeException /*-{
        return this["legend"] = (this["legend"] || {});
    }-*/
    ;

    public final native JsoChartOptions legend(Legend legend)
        throws RuntimeException /*-{
        this["legend"] = legend;
        return this;
    }-*/
    ;

    public final native Chart chart()
        throws RuntimeException /*-{
        return this["chart"] = (this["chart"] || {});
    }-*/
    ;

    public final native JsoChartOptions chart(Chart chart)
        throws RuntimeException /*-{
        this["chart"] = chart;
        return this;
    }-*/
    ;

    public final native PlotOptions plotOptions()
        throws RuntimeException /*-{
        return this["plotOptions"] = (this["plotOptions"] || {});
    }-*/
    ;

    public final native JsoChartOptions plotOptions(PlotOptions plotOptions)
        throws RuntimeException /*-{
        this["plotOptions"] = plotOptions;
        return this;
    }-*/
    ;

    public final native XAxis xAxis()
        throws RuntimeException /*-{
        return this["xAxis"] = (this["xAxis"] || {});
    }-*/
    ;

    public final native JsoChartOptions xAxis(XAxis xAxis)
        throws RuntimeException /*-{
        this["xAxis"] = xAxis;
        return this;
    }-*/
    ;

    public final native Navigation navigation()
        throws RuntimeException /*-{
        return this["navigation"] = (this["navigation"] || {});
    }-*/
    ;

    public final native JsoChartOptions navigation(Navigation navigation)
        throws RuntimeException /*-{
        this["navigation"] = navigation;
        return this;
    }-*/
    ;

    public final native Subtitle subtitle()
        throws RuntimeException /*-{
        return this["subtitle"] = (this["subtitle"] || {});
    }-*/
    ;

    public final native JsoChartOptions subtitle(Subtitle subtitle)
        throws RuntimeException /*-{
        this["subtitle"] = subtitle;
        return this;
    }-*/
    ;

    public final native Title title()
        throws RuntimeException /*-{
        return this["title"] = (this["title"] || {});
    }-*/
    ;

    public final native JsoChartOptions title(Title title)
        throws RuntimeException /*-{
        this["title"] = title;
        return this;
    }-*/
    ;

    public final native YAxis yAxis()
        throws RuntimeException /*-{
        return this["yAxis"] = (this["yAxis"] || {});
    }-*/
    ;

    public final native JsoChartOptions yAxis(YAxis yAxis)
        throws RuntimeException /*-{
        this["yAxis"] = yAxis;
        return this;
    }-*/
    ;

    public final native Tooltip tooltip()
        throws RuntimeException /*-{
        return this["tooltip"] = (this["tooltip"] || {});
    }-*/
    ;

    public final native JsoChartOptions tooltip(Tooltip tooltip)
        throws RuntimeException /*-{
        this["tooltip"] = tooltip;
        return this;
    }-*/
    ;

    public final native NoData noData()
        throws RuntimeException /*-{
        return this["noData"] = (this["noData"] || {});
    }-*/
    ;

    public final native JsoChartOptions noData(NoData noData)
        throws RuntimeException /*-{
        this["noData"] = noData;
        return this;
    }-*/
    ;

    public final native Exporting exporting()
        throws RuntimeException /*-{
        return this["exporting"] = (this["exporting"] || {});
    }-*/
    ;

    public final native JsoChartOptions exporting(Exporting exporting)
        throws RuntimeException /*-{
        this["exporting"] = exporting;
        return this;
    }-*/
    ;

    public final native Array<Series> series()
        throws RuntimeException /*-{
        return this["series"] = (this["series"] || null);
    }-*/
    ;

    public final native JsoChartOptions series(Array<Series> series)
        throws RuntimeException /*-{
        this["series"] = series;
        return this;
    }-*/
    ;

    public final native Lang lang()
        throws RuntimeException /*-{
        return this["lang"] = (this["lang"] || {});
    }-*/
    ;

    public final native JsoChartOptions lang(Lang lang)
        throws RuntimeException /*-{
        this["lang"] = lang;
        return this;
    }-*/
    ;

    public final native Credits credits()
        throws RuntimeException /*-{
        return this["credits"] = (this["credits"] || {});
    }-*/
    ;

    public final native JsoChartOptions credits(Credits credits)
        throws RuntimeException /*-{
        this["credits"] = credits;
        return this;
    }-*/
    ;

    public final native Loading loading()
        throws RuntimeException /*-{
        return this["loading"] = (this["loading"] || {});
    }-*/
    ;

    public final native JsoChartOptions loading(Loading loading)
        throws RuntimeException /*-{
        this["loading"] = loading;
        return this;
    }-*/
    ;

    public final native Labels labels()
        throws RuntimeException /*-{
        return this["labels"] = (this["labels"] || {});
    }-*/
    ;

    public final native JsoChartOptions labels(Labels labels)
        throws RuntimeException /*-{
        this["labels"] = labels;
        return this;
    }-*/
    ;

}
