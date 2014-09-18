
package com.usesoft.highcharts4gwt.model.highcharts.jso.xaxis;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Title;

public class JsoTitle
    extends JavaScriptObject
    implements Title
{


    protected JsoTitle() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || "middle");
    }-*/
    ;

    public final native JsoTitle align(String align)
        throws RuntimeException /*-{
        this["align"] = align;
        return this;
    }-*/
    ;

    public final native String enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || "middle");
    }-*/
    ;

    public final native JsoTitle enabled(String enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native Number margin()
        throws RuntimeException /*-{
        return this["margin"] = (this["margin"] || null);
    }-*/
    ;

    public final native JsoTitle margin(Number margin)
        throws RuntimeException /*-{
        this["margin"] = margin;
        return this;
    }-*/
    ;

    public final native Number offset()
        throws RuntimeException /*-{
        return this["offset"] = (this["offset"] || null);
    }-*/
    ;

    public final native JsoTitle offset(Number offset)
        throws RuntimeException /*-{
        this["offset"] = offset;
        return this;
    }-*/
    ;

    public final native Number rotation()
        throws RuntimeException /*-{
        return this["rotation"] = (this["rotation"] || 0.0);
    }-*/
    ;

    public final native JsoTitle rotation(Number rotation)
        throws RuntimeException /*-{
        this["rotation"] = rotation;
        return this;
    }-*/
    ;

    public final native String text()
        throws RuntimeException /*-{
        return this["text"] = (this["text"] || "null");
    }-*/
    ;

    public final native JsoTitle text(String text)
        throws RuntimeException /*-{
        this["text"] = text;
        return this;
    }-*/
    ;

}
