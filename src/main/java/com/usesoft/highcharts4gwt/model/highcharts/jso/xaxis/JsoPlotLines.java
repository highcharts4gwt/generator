
package com.usesoft.highcharts4gwt.model.highcharts.jso.xaxis;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotLines;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotlines.Label;

public class JsoPlotLines
    extends JavaScriptObject
    implements PlotLines
{


    protected JsoPlotLines() {
    }

    public final native String dashStyle()
        throws RuntimeException /*-{
        return this["dashStyle"] = (this["dashStyle"] || "Solid");
    }-*/
    ;

    public final native JsoPlotLines dashStyle(String dashStyle)
        throws RuntimeException /*-{
        this["dashStyle"] = dashStyle;
        return this;
    }-*/
    ;

    public final native String id()
        throws RuntimeException /*-{
        return this["id"] = (this["id"] || "null");
    }-*/
    ;

    public final native JsoPlotLines id(String id)
        throws RuntimeException /*-{
        this["id"] = id;
        return this;
    }-*/
    ;

    public final native Label label()
        throws RuntimeException /*-{
        return this["label"] = (this["label"] || null);
    }-*/
    ;

    public final native JsoPlotLines label(Label label)
        throws RuntimeException /*-{
        this["label"] = label;
        return this;
    }-*/
    ;

    public final native Number value()
        throws RuntimeException /*-{
        return this["value"] = (this["value"] || null);
    }-*/
    ;

    public final native JsoPlotLines value(Number value)
        throws RuntimeException /*-{
        this["value"] = value;
        return this;
    }-*/
    ;

    public final native Number width()
        throws RuntimeException /*-{
        return this["width"] = (this["width"] || null);
    }-*/
    ;

    public final native JsoPlotLines width(Number width)
        throws RuntimeException /*-{
        this["width"] = width;
        return this;
    }-*/
    ;

    public final native Number zIndex()
        throws RuntimeException /*-{
        return this["zIndex"] = (this["zIndex"] || null);
    }-*/
    ;

    public final native JsoPlotLines zIndex(Number zIndex)
        throws RuntimeException /*-{
        this["zIndex"] = zIndex;
        return this;
    }-*/
    ;

}
