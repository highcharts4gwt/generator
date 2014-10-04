
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.areasplinerange;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.areasplinerange.DataLabels;

public class JsoDataLabels
    extends com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.series.JsoDataLabels
    implements DataLabels
{


    protected JsoDataLabels() {
    }

    public final native Number xHigh()
        throws RuntimeException /*-{
        return this["xHigh"] = (this["xHigh"] || 0.0);
    }-*/
    ;

    public final native JsoDataLabels xHigh(Number xHigh)
        throws RuntimeException /*-{
        this["xHigh"] = xHigh;
        return this;
    }-*/
    ;

    public final native Number xLow()
        throws RuntimeException /*-{
        return this["xLow"] = (this["xLow"] || 0.0);
    }-*/
    ;

    public final native JsoDataLabels xLow(Number xLow)
        throws RuntimeException /*-{
        this["xLow"] = xLow;
        return this;
    }-*/
    ;

    public final native Number yHigh()
        throws RuntimeException /*-{
        return this["yHigh"] = (this["yHigh"] || -6.0);
    }-*/
    ;

    public final native JsoDataLabels yHigh(Number yHigh)
        throws RuntimeException /*-{
        this["yHigh"] = yHigh;
        return this;
    }-*/
    ;

    public final native Number yLow()
        throws RuntimeException /*-{
        return this["yLow"] = (this["yLow"] || 16.0);
    }-*/
    ;

    public final native JsoDataLabels yLow(Number yLow)
        throws RuntimeException /*-{
        this["yLow"] = yLow;
        return this;
    }-*/
    ;

}
