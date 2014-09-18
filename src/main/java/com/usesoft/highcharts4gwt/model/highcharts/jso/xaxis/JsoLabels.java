
package com.usesoft.highcharts4gwt.model.highcharts.jso.xaxis;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Labels;

public class JsoLabels
    extends JavaScriptObject
    implements Labels
{


    protected JsoLabels() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || "center");
    }-*/
    ;

    public final native JsoLabels align(String align)
        throws RuntimeException /*-{
        this["align"] = align;
        return this;
    }-*/
    ;

    public final native Number distance()
        throws RuntimeException /*-{
        return this["distance"] = (this["distance"] || 15.0);
    }-*/
    ;

    public final native JsoLabels distance(Number distance)
        throws RuntimeException /*-{
        this["distance"] = distance;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || true);
    }-*/
    ;

    public final native JsoLabels enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native String format()
        throws RuntimeException /*-{
        return this["format"] = (this["format"] || "{value}");
    }-*/
    ;

    public final native JsoLabels format(String format)
        throws RuntimeException /*-{
        this["format"] = format;
        return this;
    }-*/
    ;

    public final native Number maxStaggerLines()
        throws RuntimeException /*-{
        return this["maxStaggerLines"] = (this["maxStaggerLines"] || 5.0);
    }-*/
    ;

    public final native JsoLabels maxStaggerLines(Number maxStaggerLines)
        throws RuntimeException /*-{
        this["maxStaggerLines"] = maxStaggerLines;
        return this;
    }-*/
    ;

    public final native String overflow()
        throws RuntimeException /*-{
        return this["overflow"] = (this["overflow"] || "null");
    }-*/
    ;

    public final native JsoLabels overflow(String overflow)
        throws RuntimeException /*-{
        this["overflow"] = overflow;
        return this;
    }-*/
    ;

    public final native Number rotation()
        throws RuntimeException /*-{
        return this["rotation"] = (this["rotation"] || 0.0);
    }-*/
    ;

    public final native JsoLabels rotation(Number rotation)
        throws RuntimeException /*-{
        this["rotation"] = rotation;
        return this;
    }-*/
    ;

    public final native Number staggerLines()
        throws RuntimeException /*-{
        return this["staggerLines"] = (this["staggerLines"] || null);
    }-*/
    ;

    public final native JsoLabels staggerLines(Number staggerLines)
        throws RuntimeException /*-{
        this["staggerLines"] = staggerLines;
        return this;
    }-*/
    ;

    public final native Number step()
        throws RuntimeException /*-{
        return this["step"] = (this["step"] || null);
    }-*/
    ;

    public final native JsoLabels step(Number step)
        throws RuntimeException /*-{
        this["step"] = step;
        return this;
    }-*/
    ;

    public final native boolean useHTML()
        throws RuntimeException /*-{
        return this["useHTML"] = (this["useHTML"] || false);
    }-*/
    ;

    public final native JsoLabels useHTML(boolean useHTML)
        throws RuntimeException /*-{
        this["useHTML"] = useHTML;
        return this;
    }-*/
    ;

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || 0.0);
    }-*/
    ;

    public final native JsoLabels x(Number x)
        throws RuntimeException /*-{
        this["x"] = x;
        return this;
    }-*/
    ;

    public final native Number y()
        throws RuntimeException /*-{
        return this["y"] = (this["y"] || null);
    }-*/
    ;

    public final native JsoLabels y(Number y)
        throws RuntimeException /*-{
        this["y"] = y;
        return this;
    }-*/
    ;

    public final native Number zIndex()
        throws RuntimeException /*-{
        return this["zIndex"] = (this["zIndex"] || 7.0);
    }-*/
    ;

    public final native JsoLabels zIndex(Number zIndex)
        throws RuntimeException /*-{
        this["zIndex"] = zIndex;
        return this;
    }-*/
    ;

}
