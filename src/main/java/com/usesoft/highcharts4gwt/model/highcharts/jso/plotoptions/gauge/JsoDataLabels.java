
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.gauge;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.gauge.DataLabels;

public class JsoDataLabels
    extends JavaScriptObject
    implements DataLabels
{


    protected JsoDataLabels() {
    }

    public final native Number borderRadius()
        throws RuntimeException /*-{
        return this["borderRadius"] = (this["borderRadius"] || 3.0);
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
        return this["borderWidth"] = (this["borderWidth"] || 1.0);
    }-*/
    ;

    public final native JsoDataLabels borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || false);
    }-*/
    ;

    public final native JsoDataLabels enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native String verticalAlign()
        throws RuntimeException /*-{
        return this["verticalAlign"] = (this["verticalAlign"] || "top");
    }-*/
    ;

    public final native JsoDataLabels verticalAlign(String verticalAlign)
        throws RuntimeException /*-{
        this["verticalAlign"] = verticalAlign;
        return this;
    }-*/
    ;

    public final native Number y()
        throws RuntimeException /*-{
        return this["y"] = (this["y"] || 15.0);
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
        return this["zIndex"] = (this["zIndex"] || 2.0);
    }-*/
    ;

    public final native JsoDataLabels zIndex(Number zIndex)
        throws RuntimeException /*-{
        this["zIndex"] = zIndex;
        return this;
    }-*/
    ;

}
