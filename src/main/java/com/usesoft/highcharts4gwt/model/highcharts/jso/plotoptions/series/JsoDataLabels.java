
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.series;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.DataLabels;

public class JsoDataLabels
    extends JavaScriptObject
    implements DataLabels
{


    protected JsoDataLabels() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || {});
    }-*/
    ;

    public final native JsoDataLabels align(String align)
        throws RuntimeException /*-{
        this["align"] = align;
        return this;
    }-*/
    ;

    public final native Number borderRadius()
        throws RuntimeException /*-{
        return this["borderRadius"] = (this["borderRadius"] || {});
    }-*/
    ;

    public final native JsoDataLabels borderRadius(Number borderRadius)
        throws RuntimeException /*-{
        this["borderRadius"] = borderRadius;
        return this;
    }-*/
    ;

    public final native Number borderWidth()
        throws RuntimeException /*-{
        return this["borderWidth"] = (this["borderWidth"] || {});
    }-*/
    ;

    public final native JsoDataLabels borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native boolean crop()
        throws RuntimeException /*-{
        return this["crop"] = (this["crop"] || {});
    }-*/
    ;

    public final native JsoDataLabels crop(boolean crop)
        throws RuntimeException /*-{
        this["crop"] = crop;
        return this;
    }-*/
    ;

    public final native boolean defer()
        throws RuntimeException /*-{
        return this["defer"] = (this["defer"] || {});
    }-*/
    ;

    public final native JsoDataLabels defer(boolean defer)
        throws RuntimeException /*-{
        this["defer"] = defer;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || {});
    }-*/
    ;

    public final native JsoDataLabels enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native String format()
        throws RuntimeException /*-{
        return this["format"] = (this["format"] || {});
    }-*/
    ;

    public final native JsoDataLabels format(String format)
        throws RuntimeException /*-{
        this["format"] = format;
        return this;
    }-*/
    ;

    public final native boolean inside()
        throws RuntimeException /*-{
        return this["inside"] = (this["inside"] || {});
    }-*/
    ;

    public final native JsoDataLabels inside(boolean inside)
        throws RuntimeException /*-{
        this["inside"] = inside;
        return this;
    }-*/
    ;

    public final native String overflow()
        throws RuntimeException /*-{
        return this["overflow"] = (this["overflow"] || {});
    }-*/
    ;

    public final native JsoDataLabels overflow(String overflow)
        throws RuntimeException /*-{
        this["overflow"] = overflow;
        return this;
    }-*/
    ;

    public final native Number padding()
        throws RuntimeException /*-{
        return this["padding"] = (this["padding"] || {});
    }-*/
    ;

    public final native JsoDataLabels padding(Number padding)
        throws RuntimeException /*-{
        this["padding"] = padding;
        return this;
    }-*/
    ;

    public final native Number rotation()
        throws RuntimeException /*-{
        return this["rotation"] = (this["rotation"] || {});
    }-*/
    ;

    public final native JsoDataLabels rotation(Number rotation)
        throws RuntimeException /*-{
        this["rotation"] = rotation;
        return this;
    }-*/
    ;

    public final native String verticalAlign()
        throws RuntimeException /*-{
        return this["verticalAlign"] = (this["verticalAlign"] || {});
    }-*/
    ;

    public final native JsoDataLabels verticalAlign(String verticalAlign)
        throws RuntimeException /*-{
        this["verticalAlign"] = verticalAlign;
        return this;
    }-*/
    ;

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || {});
    }-*/
    ;

    public final native JsoDataLabels x(Number x)
        throws RuntimeException /*-{
        this["x"] = x;
        return this;
    }-*/
    ;

    public final native Number y()
        throws RuntimeException /*-{
        return this["y"] = (this["y"] || {});
    }-*/
    ;

    public final native JsoDataLabels y(Number y)
        throws RuntimeException /*-{
        this["y"] = y;
        return this;
    }-*/
    ;

    public final native Number zIndex()
        throws RuntimeException /*-{
        return this["zIndex"] = (this["zIndex"] || {});
    }-*/
    ;

    public final native JsoDataLabels zIndex(Number zIndex)
        throws RuntimeException /*-{
        this["zIndex"] = zIndex;
        return this;
    }-*/
    ;

}
