
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Waterfall;

public class JsoWaterfall
    extends JavaScriptObject
    implements Waterfall
{


    protected JsoWaterfall() {
    }

    public final native String dashStyle()
        throws RuntimeException /*-{
        return this["dashStyle"] = (this["dashStyle"] || "Dot");
    }-*/
    ;

    public final native JsoWaterfall dashStyle(String dashStyle)
        throws RuntimeException /*-{
        this["dashStyle"] = dashStyle;
        return this;
    }-*/
    ;

}
