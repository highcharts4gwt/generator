
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.solidgauge.states;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.solidgauge.states.Hover;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.solidgauge.states.hover.Marker;

public class JsoHover
    extends JavaScriptObject
    implements Hover
{


    protected JsoHover() {
    }

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || true);
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
        return this["lineWidth"] = (this["lineWidth"] || 2.0);
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
        return this["lineWidthPlus"] = (this["lineWidthPlus"] || 1.0);
    }-*/
    ;

    public final native JsoHover lineWidthPlus(Number lineWidthPlus)
        throws RuntimeException /*-{
        this["lineWidthPlus"] = lineWidthPlus;
        return this;
    }-*/
    ;

    public final native Marker marker()
        throws RuntimeException /*-{
        return this["marker"] = (this["marker"] || {});
    }-*/
    ;

    public final native JsoHover marker(Marker marker)
        throws RuntimeException /*-{
        this["marker"] = marker;
        return this;
    }-*/
    ;

}
