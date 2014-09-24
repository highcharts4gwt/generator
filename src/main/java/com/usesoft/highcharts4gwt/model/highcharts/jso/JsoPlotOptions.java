
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.PlotOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Area;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Areaspline;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Bar;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Line;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Pie;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Spline;

public class JsoPlotOptions
    extends JavaScriptObject
    implements PlotOptions
{


    protected JsoPlotOptions() {
    }

    public final native Area area()
        throws RuntimeException /*-{
        return this["area"] = (this["area"] || {});
    }-*/
    ;

    public final native JsoPlotOptions area(Area area)
        throws RuntimeException /*-{
        this["area"] = area;
        return this;
    }-*/
    ;

    public final native Areaspline areaspline()
        throws RuntimeException /*-{
        return this["areaspline"] = (this["areaspline"] || {});
    }-*/
    ;

    public final native JsoPlotOptions areaspline(Areaspline areaspline)
        throws RuntimeException /*-{
        this["areaspline"] = areaspline;
        return this;
    }-*/
    ;

    public final native Bar bar()
        throws RuntimeException /*-{
        return this["bar"] = (this["bar"] || {});
    }-*/
    ;

    public final native JsoPlotOptions bar(Bar bar)
        throws RuntimeException /*-{
        this["bar"] = bar;
        return this;
    }-*/
    ;

    public final native Line line()
        throws RuntimeException /*-{
        return this["line"] = (this["line"] || {});
    }-*/
    ;

    public final native JsoPlotOptions line(Line line)
        throws RuntimeException /*-{
        this["line"] = line;
        return this;
    }-*/
    ;

    public final native Pie pie()
        throws RuntimeException /*-{
        return this["pie"] = (this["pie"] || {});
    }-*/
    ;

    public final native JsoPlotOptions pie(Pie pie)
        throws RuntimeException /*-{
        this["pie"] = pie;
        return this;
    }-*/
    ;

    public final native Series series()
        throws RuntimeException /*-{
        return this["series"] = (this["series"] || {});
    }-*/
    ;

    public final native JsoPlotOptions series(Series series)
        throws RuntimeException /*-{
        this["series"] = series;
        return this;
    }-*/
    ;

    public final native Spline spline()
        throws RuntimeException /*-{
        return this["spline"] = (this["spline"] || {});
    }-*/
    ;

    public final native JsoPlotOptions spline(Spline spline)
        throws RuntimeException /*-{
        this["spline"] = spline;
        return this;
    }-*/
    ;

}
