
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.arearange;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.arearange.DataLabels;

public class JsoDataLabels
    extends JavaScriptObject
    implements DataLabels
{


    protected JsoDataLabels() {
    }

    public final native Number xHigh()
        throws RuntimeException /*-{
        return this["xHigh"] = (this["xHigh"] || {});
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
        return this["xLow"] = (this["xLow"] || {});
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
        return this["yHigh"] = (this["yHigh"] || {});
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
        return this["yLow"] = (this["yLow"] || {});
    }-*/
    ;

    public final native JsoDataLabels yLow(Number yLow)
        throws RuntimeException /*-{
        this["yLow"] = yLow;
        return this;
    }-*/
    ;

}
