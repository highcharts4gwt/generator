
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.series.marker.states;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.marker.states.Hover;

public class JsoHover
    extends JavaScriptObject
    implements Hover
{


    protected JsoHover() {
    }

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || {});
    }-*/
    ;

    public final native JsoHover enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native Number lineWidth()
        throws RuntimeException /*-{
        return this["lineWidth"] = (this["lineWidth"] || {});
    }-*/
    ;

    public final native JsoHover lineWidth(Number lineWidth)
        throws RuntimeException /*-{
        this["lineWidth"] = lineWidth;
        return this;
    }-*/
    ;

    public final native Number lineWidthPlus()
        throws RuntimeException /*-{
        return this["lineWidthPlus"] = (this["lineWidthPlus"] || {});
    }-*/
    ;

    public final native JsoHover lineWidthPlus(Number lineWidthPlus)
        throws RuntimeException /*-{
        this["lineWidthPlus"] = lineWidthPlus;
        return this;
    }-*/
    ;

    public final native Number radius()
        throws RuntimeException /*-{
        return this["radius"] = (this["radius"] || {});
    }-*/
    ;

    public final native JsoHover radius(Number radius)
        throws RuntimeException /*-{
        this["radius"] = radius;
        return this;
    }-*/
    ;

    public final native Number radiusPlus()
        throws RuntimeException /*-{
        return this["radiusPlus"] = (this["radiusPlus"] || {});
    }-*/
    ;

    public final native JsoHover radiusPlus(Number radiusPlus)
        throws RuntimeException /*-{
        this["radiusPlus"] = radiusPlus;
        return this;
    }-*/
    ;

}
