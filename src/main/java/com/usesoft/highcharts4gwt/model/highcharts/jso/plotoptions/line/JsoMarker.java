
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.line;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.line.Marker;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.line.marker.States;

public class JsoMarker
    extends JavaScriptObject
    implements Marker
{


    protected JsoMarker() {
    }

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || true);
    }-*/
    ;

    public final native JsoMarker enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native Number height()
        throws RuntimeException /*-{
        return this["height"] = (this["height"] || null);
    }-*/
    ;

    public final native JsoMarker height(Number height)
        throws RuntimeException /*-{
        this["height"] = height;
        return this;
    }-*/
    ;

    public final native Number lineWidth()
        throws RuntimeException /*-{
        return this["lineWidth"] = (this["lineWidth"] || 0.0);
    }-*/
    ;

    public final native JsoMarker lineWidth(Number lineWidth)
        throws RuntimeException /*-{
        this["lineWidth"] = lineWidth;
        return this;
    }-*/
    ;

    public final native Number radius()
        throws RuntimeException /*-{
        return this["radius"] = (this["radius"] || 4.0);
    }-*/
    ;

    public final native JsoMarker radius(Number radius)
        throws RuntimeException /*-{
        this["radius"] = radius;
        return this;
    }-*/
    ;

    public final native States states()
        throws RuntimeException /*-{
        return this["states"] = (this["states"] || {});
    }-*/
    ;

    public final native JsoMarker states(States states)
        throws RuntimeException /*-{
        this["states"] = states;
        return this;
    }-*/
    ;

    public final native String symbol()
        throws RuntimeException /*-{
        return this["symbol"] = (this["symbol"] || "null");
    }-*/
    ;

    public final native JsoMarker symbol(String symbol)
        throws RuntimeException /*-{
        this["symbol"] = symbol;
        return this;
    }-*/
    ;

    public final native Number width()
        throws RuntimeException /*-{
        return this["width"] = (this["width"] || null);
    }-*/
    ;

    public final native JsoMarker width(Number width)
        throws RuntimeException /*-{
        this["width"] = width;
        return this;
    }-*/
    ;

}
