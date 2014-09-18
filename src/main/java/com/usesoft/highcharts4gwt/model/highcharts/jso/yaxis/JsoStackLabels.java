
package com.usesoft.highcharts4gwt.model.highcharts.jso.yaxis;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.StackLabels;

public class JsoStackLabels
    extends JavaScriptObject
    implements StackLabels
{


    protected JsoStackLabels() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || "null");
    }-*/
    ;

    public final native JsoStackLabels align(String align)
        throws RuntimeException /*-{
        this["align"] = align;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || false);
    }-*/
    ;

    public final native JsoStackLabels enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native String format()
        throws RuntimeException /*-{
        return this["format"] = (this["format"] || "{total}");
    }-*/
    ;

    public final native JsoStackLabels format(String format)
        throws RuntimeException /*-{
        this["format"] = format;
        return this;
    }-*/
    ;

    public final native Number rotation()
        throws RuntimeException /*-{
        return this["rotation"] = (this["rotation"] || 0.0);
    }-*/
    ;

    public final native JsoStackLabels rotation(Number rotation)
        throws RuntimeException /*-{
        this["rotation"] = rotation;
        return this;
    }-*/
    ;

    public final native String textAlign()
        throws RuntimeException /*-{
        return this["textAlign"] = (this["textAlign"] || "null");
    }-*/
    ;

    public final native JsoStackLabels textAlign(String textAlign)
        throws RuntimeException /*-{
        this["textAlign"] = textAlign;
        return this;
    }-*/
    ;

    public final native boolean useHTML()
        throws RuntimeException /*-{
        return this["useHTML"] = (this["useHTML"] || false);
    }-*/
    ;

    public final native JsoStackLabels useHTML(boolean useHTML)
        throws RuntimeException /*-{
        this["useHTML"] = useHTML;
        return this;
    }-*/
    ;

    public final native String verticalAlign()
        throws RuntimeException /*-{
        return this["verticalAlign"] = (this["verticalAlign"] || "null");
    }-*/
    ;

    public final native JsoStackLabels verticalAlign(String verticalAlign)
        throws RuntimeException /*-{
        this["verticalAlign"] = verticalAlign;
        return this;
    }-*/
    ;

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || null);
    }-*/
    ;

    public final native JsoStackLabels x(Number x)
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

    public final native JsoStackLabels y(Number y)
        throws RuntimeException /*-{
        this["y"] = y;
        return this;
    }-*/
    ;

}
