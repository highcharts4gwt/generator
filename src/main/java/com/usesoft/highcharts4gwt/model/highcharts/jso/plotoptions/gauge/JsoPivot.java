
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.gauge;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.gauge.Pivot;

public class JsoPivot
    extends JavaScriptObject
    implements Pivot
{


    protected JsoPivot() {
    }

    public final native Number borderWidth()
        throws RuntimeException /*-{
        return this["borderWidth"] = (this["borderWidth"] || 0.0);
    }-*/
    ;

    public final native JsoPivot borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native Number radius()
        throws RuntimeException /*-{
        return this["radius"] = (this["radius"] || 5.0);
    }-*/
    ;

    public final native JsoPivot radius(Number radius)
        throws RuntimeException /*-{
        this["radius"] = radius;
        return this;
    }-*/
    ;

}
