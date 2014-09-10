
package com.usesoft.highcharts4gwt.model.highcharts.jso.drilldown;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.drilldown.DrillUpButton;

public class JsoDrillUpButton
    extends JavaScriptObject
    implements DrillUpButton
{


    protected JsoDrillUpButton() {
    }

    public final native String relativeTo()
        throws RuntimeException /*-{
        return this["relativeTo"] = (this["relativeTo"] || {});
    }-*/
    ;

    public final native JsoDrillUpButton relativeTo(String relativeTo)
        throws RuntimeException /*-{
        this["relativeTo"] = relativeTo;
        return this;
    }-*/
    ;

}
