
package com.usesoft.highcharts4gwt.model.highcharts.jso.chart;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.ResetZoomButton;

public class JsoResetZoomButton
    extends JavaScriptObject
    implements ResetZoomButton
{


    protected JsoResetZoomButton() {
    }

    public final native String relativeTo()
        throws RuntimeException /*-{
        return this["relativeTo"] = (this["relativeTo"] || "plot");
    }-*/
    ;

    public final native JsoResetZoomButton relativeTo(String relativeTo)
        throws RuntimeException /*-{
        this["relativeTo"] = relativeTo;
        return this;
    }-*/
    ;

}
