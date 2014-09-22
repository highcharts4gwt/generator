
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Legend;
import com.usesoft.highcharts4gwt.model.highcharts.api.legend.Navigation;

public class JsoLegend
    extends JavaScriptObject
    implements Legend
{


    protected JsoLegend() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || "center");
    }-*/
    ;

    public final native JsoLegend align(String align)
        throws RuntimeException /*-{
        this["align"] = align;
        return this;
    }-*/
    ;

    public final native Number borderRadius()
        throws RuntimeException /*-{
        return this["borderRadius"] = (this["borderRadius"] || 0.0);
    }-*/
    ;

    public final native JsoLegend borderRadius(Number borderRadius)
        throws RuntimeException /*-{
        this["borderRadius"] = borderRadius;
        return this;
    }-*/
    ;

    public final native Number borderWidth()
        throws RuntimeException /*-{
        return this["borderWidth"] = (this["borderWidth"] || 0.0);
    }-*/
    ;

    public final native JsoLegend borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || true);
    }-*/
    ;

    public final native JsoLegend enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native boolean floating()
        throws RuntimeException /*-{
        return this["floating"] = (this["floating"] || false);
    }-*/
    ;

    public final native JsoLegend floating(boolean floating)
        throws RuntimeException /*-{
        this["floating"] = floating;
        return this;
    }-*/
    ;

    public final native Number itemDistance()
        throws RuntimeException /*-{
        return this["itemDistance"] = (this["itemDistance"] || 20.0);
    }-*/
    ;

    public final native JsoLegend itemDistance(Number itemDistance)
        throws RuntimeException /*-{
        this["itemDistance"] = itemDistance;
        return this;
    }-*/
    ;

    public final native Number itemMarginBottom()
        throws RuntimeException /*-{
        return this["itemMarginBottom"] = (this["itemMarginBottom"] || 0.0);
    }-*/
    ;

    public final native JsoLegend itemMarginBottom(Number itemMarginBottom)
        throws RuntimeException /*-{
        this["itemMarginBottom"] = itemMarginBottom;
        return this;
    }-*/
    ;

    public final native Number itemMarginTop()
        throws RuntimeException /*-{
        return this["itemMarginTop"] = (this["itemMarginTop"] || 0.0);
    }-*/
    ;

    public final native JsoLegend itemMarginTop(Number itemMarginTop)
        throws RuntimeException /*-{
        this["itemMarginTop"] = itemMarginTop;
        return this;
    }-*/
    ;

    public final native Number itemWidth()
        throws RuntimeException /*-{
        return this["itemWidth"] = (this["itemWidth"] || null);
    }-*/
    ;

    public final native JsoLegend itemWidth(Number itemWidth)
        throws RuntimeException /*-{
        this["itemWidth"] = itemWidth;
        return this;
    }-*/
    ;

    public final native String labelFormat()
        throws RuntimeException /*-{
        return this["labelFormat"] = (this["labelFormat"] || "{name}");
    }-*/
    ;

    public final native JsoLegend labelFormat(String labelFormat)
        throws RuntimeException /*-{
        this["labelFormat"] = labelFormat;
        return this;
    }-*/
    ;

    public final native String layout()
        throws RuntimeException /*-{
        return this["layout"] = (this["layout"] || "horizontal");
    }-*/
    ;

    public final native JsoLegend layout(String layout)
        throws RuntimeException /*-{
        this["layout"] = layout;
        return this;
    }-*/
    ;

    public final native Number lineHeight()
        throws RuntimeException /*-{
        return this["lineHeight"] = (this["lineHeight"] || 16.0);
    }-*/
    ;

    public final native JsoLegend lineHeight(Number lineHeight)
        throws RuntimeException /*-{
        this["lineHeight"] = lineHeight;
        return this;
    }-*/
    ;

    public final native Number margin()
        throws RuntimeException /*-{
        return this["margin"] = (this["margin"] || 15.0);
    }-*/
    ;

    public final native JsoLegend margin(Number margin)
        throws RuntimeException /*-{
        this["margin"] = margin;
        return this;
    }-*/
    ;

    public final native Number maxHeight()
        throws RuntimeException /*-{
        return this["maxHeight"] = (this["maxHeight"] || null);
    }-*/
    ;

    public final native JsoLegend maxHeight(Number maxHeight)
        throws RuntimeException /*-{
        this["maxHeight"] = maxHeight;
        return this;
    }-*/
    ;

    public final native Navigation navigation()
        throws RuntimeException /*-{
        return this["navigation"] = (this["navigation"] || null);
    }-*/
    ;

    public final native JsoLegend navigation(Navigation navigation)
        throws RuntimeException /*-{
        this["navigation"] = navigation;
        return this;
    }-*/
    ;

    public final native Number padding()
        throws RuntimeException /*-{
        return this["padding"] = (this["padding"] || 8.0);
    }-*/
    ;

    public final native JsoLegend padding(Number padding)
        throws RuntimeException /*-{
        this["padding"] = padding;
        return this;
    }-*/
    ;

    public final native boolean reversed()
        throws RuntimeException /*-{
        return this["reversed"] = (this["reversed"] || false);
    }-*/
    ;

    public final native JsoLegend reversed(boolean reversed)
        throws RuntimeException /*-{
        this["reversed"] = reversed;
        return this;
    }-*/
    ;

    public final native boolean rtl()
        throws RuntimeException /*-{
        return this["rtl"] = (this["rtl"] || false);
    }-*/
    ;

    public final native JsoLegend rtl(boolean rtl)
        throws RuntimeException /*-{
        this["rtl"] = rtl;
        return this;
    }-*/
    ;

    public final native Number symbolHeight()
        throws RuntimeException /*-{
        return this["symbolHeight"] = (this["symbolHeight"] || 12.0);
    }-*/
    ;

    public final native JsoLegend symbolHeight(Number symbolHeight)
        throws RuntimeException /*-{
        this["symbolHeight"] = symbolHeight;
        return this;
    }-*/
    ;

    public final native Number symbolPadding()
        throws RuntimeException /*-{
        return this["symbolPadding"] = (this["symbolPadding"] || 5.0);
    }-*/
    ;

    public final native JsoLegend symbolPadding(Number symbolPadding)
        throws RuntimeException /*-{
        this["symbolPadding"] = symbolPadding;
        return this;
    }-*/
    ;

    public final native Number symbolRadius()
        throws RuntimeException /*-{
        return this["symbolRadius"] = (this["symbolRadius"] || 2.0);
    }-*/
    ;

    public final native JsoLegend symbolRadius(Number symbolRadius)
        throws RuntimeException /*-{
        this["symbolRadius"] = symbolRadius;
        return this;
    }-*/
    ;

    public final native Number symbolWidth()
        throws RuntimeException /*-{
        return this["symbolWidth"] = (this["symbolWidth"] || 16.0);
    }-*/
    ;

    public final native JsoLegend symbolWidth(Number symbolWidth)
        throws RuntimeException /*-{
        this["symbolWidth"] = symbolWidth;
        return this;
    }-*/
    ;

    public final native boolean useHTML()
        throws RuntimeException /*-{
        return this["useHTML"] = (this["useHTML"] || false);
    }-*/
    ;

    public final native JsoLegend useHTML(boolean useHTML)
        throws RuntimeException /*-{
        this["useHTML"] = useHTML;
        return this;
    }-*/
    ;

    public final native String verticalAlign()
        throws RuntimeException /*-{
        return this["verticalAlign"] = (this["verticalAlign"] || "bottom");
    }-*/
    ;

    public final native JsoLegend verticalAlign(String verticalAlign)
        throws RuntimeException /*-{
        this["verticalAlign"] = verticalAlign;
        return this;
    }-*/
    ;

    public final native Number width()
        throws RuntimeException /*-{
        return this["width"] = (this["width"] || null);
    }-*/
    ;

    public final native JsoLegend width(Number width)
        throws RuntimeException /*-{
        this["width"] = width;
        return this;
    }-*/
    ;

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || 0.0);
    }-*/
    ;

    public final native JsoLegend x(Number x)
        throws RuntimeException /*-{
        this["x"] = x;
        return this;
    }-*/
    ;

    public final native Number y()
        throws RuntimeException /*-{
        return this["y"] = (this["y"] || 0.0);
    }-*/
    ;

    public final native JsoLegend y(Number y)
        throws RuntimeException /*-{
        this["y"] = y;
        return this;
    }-*/
    ;

}
