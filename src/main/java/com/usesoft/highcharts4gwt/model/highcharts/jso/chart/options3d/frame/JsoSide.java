
package com.usesoft.highcharts4gwt.model.highcharts.jso.chart.options3d.frame;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.frame.Side;

public class JsoSide
    extends JavaScriptObject
    implements Side
{


    protected JsoSide() {
    }

    public final native Number size()
        throws RuntimeException /*-{
        return this["size"] = (this["size"] || 1.0);
    }-*/
    ;

    public final native JsoSide size(Number size)
        throws RuntimeException /*-{
        this["size"] = size;
        return this;
    }-*/
    ;

}
