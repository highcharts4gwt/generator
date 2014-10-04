
package com.usesoft.highcharts4gwt.model.highcharts.jso.xaxis;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotBand;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotbands.Label;

public class JsoPlotBand
    extends JavaScriptObject
    implements PlotBand
{


    protected JsoPlotBand() {
    }

    public final native Number borderWidth()
        throws RuntimeException /*-{
        return this["borderWidth"] = (this["borderWidth"] || 0.0);
    }-*/
    ;

    public final native JsoPlotBand borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native Number from()
        throws RuntimeException /*-{
        return this["from"] = (this["from"] || null);
    }-*/
    ;

    public final native JsoPlotBand from(Number from)
        throws RuntimeException /*-{
        this["from"] = from;
        return this;
    }-*/
    ;

    public final native String id()
        throws RuntimeException /*-{
        return this["id"] = (this["id"] || "null");
    }-*/
    ;

    public final native JsoPlotBand id(String id)
        throws RuntimeException /*-{
        this["id"] = id;
        return this;
    }-*/
    ;

    public final native Label label()
        throws RuntimeException /*-{
        return this["label"] = (this["label"] || {});
    }-*/
    ;

    public final native JsoPlotBand label(Label label)
        throws RuntimeException /*-{
        this["label"] = label;
        return this;
    }-*/
    ;

    public final native Number to()
        throws RuntimeException /*-{
        return this["to"] = (this["to"] || null);
    }-*/
    ;

    public final native JsoPlotBand to(Number to)
        throws RuntimeException /*-{
        this["to"] = to;
        return this;
    }-*/
    ;

    public final native Number zIndex()
        throws RuntimeException /*-{
        return this["zIndex"] = (this["zIndex"] || null);
    }-*/
    ;

    public final native JsoPlotBand zIndex(Number zIndex)
        throws RuntimeException /*-{
        this["zIndex"] = zIndex;
        return this;
    }-*/
    ;

}
