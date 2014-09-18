
package com.usesoft.highcharts4gwt.model.highcharts.jso.yaxis;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Labels;

public class JsoLabels
    extends JavaScriptObject
    implements Labels
{


    protected JsoLabels() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || "right");
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

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || null);
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
        return this["y"] = (this["y"] || 3.0);
    }-*/
    ;

    public final native JsoLabels y(Number y)
        throws RuntimeException /*-{
        this["y"] = y;
        return this;
    }-*/
    ;

}
