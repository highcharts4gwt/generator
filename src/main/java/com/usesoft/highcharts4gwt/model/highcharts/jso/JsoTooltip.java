
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Tooltip;

public class JsoTooltip
    extends JavaScriptObject
    implements Tooltip
{


    protected JsoTooltip() {
    }

    public final native boolean animation()
        throws RuntimeException /*-{
        return this["animation"] = (this["animation"] || {});
    }-*/
    ;

    public final native JsoTooltip animation(boolean animation)
        throws RuntimeException /*-{
        this["animation"] = animation;
        return this;
    }-*/
    ;

    public final native Number borderRadius()
        throws RuntimeException /*-{
        return this["borderRadius"] = (this["borderRadius"] || {});
    }-*/
    ;

    public final native JsoTooltip borderRadius(Number borderRadius)
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

    public final native JsoTooltip borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || {});
    }-*/
    ;

    public final native JsoTooltip enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native boolean followPointer()
        throws RuntimeException /*-{
        return this["followPointer"] = (this["followPointer"] || {});
    }-*/
    ;

    public final native JsoTooltip followPointer(boolean followPointer)
        throws RuntimeException /*-{
        this["followPointer"] = followPointer;
        return this;
    }-*/
    ;

    public final native boolean followTouchMove()
        throws RuntimeException /*-{
        return this["followTouchMove"] = (this["followTouchMove"] || {});
    }-*/
    ;

    public final native JsoTooltip followTouchMove(boolean followTouchMove)
        throws RuntimeException /*-{
        this["followTouchMove"] = followTouchMove;
        return this;
    }-*/
    ;

    public final native String footerFormat()
        throws RuntimeException /*-{
        return this["footerFormat"] = (this["footerFormat"] || {});
    }-*/
    ;

    public final native JsoTooltip footerFormat(String footerFormat)
        throws RuntimeException /*-{
        this["footerFormat"] = footerFormat;
        return this;
    }-*/
    ;

    public final native String headerFormat()
        throws RuntimeException /*-{
        return this["headerFormat"] = (this["headerFormat"] || {});
    }-*/
    ;

    public final native JsoTooltip headerFormat(String headerFormat)
        throws RuntimeException /*-{
        this["headerFormat"] = headerFormat;
        return this;
    }-*/
    ;

    public final native Number hideDelay()
        throws RuntimeException /*-{
        return this["hideDelay"] = (this["hideDelay"] || {});
    }-*/
    ;

    public final native JsoTooltip hideDelay(Number hideDelay)
        throws RuntimeException /*-{
        this["hideDelay"] = hideDelay;
        return this;
    }-*/
    ;

    public final native String pointFormat()
        throws RuntimeException /*-{
        return this["pointFormat"] = (this["pointFormat"] || {});
    }-*/
    ;

    public final native JsoTooltip pointFormat(String pointFormat)
        throws RuntimeException /*-{
        this["pointFormat"] = pointFormat;
        return this;
    }-*/
    ;

    public final native boolean shadow()
        throws RuntimeException /*-{
        return this["shadow"] = (this["shadow"] || {});
    }-*/
    ;

    public final native JsoTooltip shadow(boolean shadow)
        throws RuntimeException /*-{
        this["shadow"] = shadow;
        return this;
    }-*/
    ;

    public final native String shape()
        throws RuntimeException /*-{
        return this["shape"] = (this["shape"] || {});
    }-*/
    ;

    public final native JsoTooltip shape(String shape)
        throws RuntimeException /*-{
        this["shape"] = shape;
        return this;
    }-*/
    ;

    public final native boolean shared()
        throws RuntimeException /*-{
        return this["shared"] = (this["shared"] || {});
    }-*/
    ;

    public final native JsoTooltip shared(boolean shared)
        throws RuntimeException /*-{
        this["shared"] = shared;
        return this;
    }-*/
    ;

    public final native Number snap()
        throws RuntimeException /*-{
        return this["snap"] = (this["snap"] || {});
    }-*/
    ;

    public final native JsoTooltip snap(Number snap)
        throws RuntimeException /*-{
        this["snap"] = snap;
        return this;
    }-*/
    ;

    public final native boolean useHTML()
        throws RuntimeException /*-{
        return this["useHTML"] = (this["useHTML"] || {});
    }-*/
    ;

    public final native JsoTooltip useHTML(boolean useHTML)
        throws RuntimeException /*-{
        this["useHTML"] = useHTML;
        return this;
    }-*/
    ;

    public final native Number valueDecimals()
        throws RuntimeException /*-{
        return this["valueDecimals"] = (this["valueDecimals"] || {});
    }-*/
    ;

    public final native JsoTooltip valueDecimals(Number valueDecimals)
        throws RuntimeException /*-{
        this["valueDecimals"] = valueDecimals;
        return this;
    }-*/
    ;

    public final native String valuePrefix()
        throws RuntimeException /*-{
        return this["valuePrefix"] = (this["valuePrefix"] || {});
    }-*/
    ;

    public final native JsoTooltip valuePrefix(String valuePrefix)
        throws RuntimeException /*-{
        this["valuePrefix"] = valuePrefix;
        return this;
    }-*/
    ;

    public final native String valueSuffix()
        throws RuntimeException /*-{
        return this["valueSuffix"] = (this["valueSuffix"] || {});
    }-*/
    ;

    public final native JsoTooltip valueSuffix(String valueSuffix)
        throws RuntimeException /*-{
        this["valueSuffix"] = valueSuffix;
        return this;
    }-*/
    ;

    public final native String xDateFormat()
        throws RuntimeException /*-{
        return this["xDateFormat"] = (this["xDateFormat"] || {});
    }-*/
    ;

    public final native JsoTooltip xDateFormat(String xDateFormat)
        throws RuntimeException /*-{
        this["xDateFormat"] = xDateFormat;
        return this;
    }-*/
    ;

}
