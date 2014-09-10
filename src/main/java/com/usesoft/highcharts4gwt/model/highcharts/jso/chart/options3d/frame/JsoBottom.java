
package com.usesoft.highcharts4gwt.model.highcharts.jso.chart.options3d.frame;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.frame.Bottom;

public class JsoBottom
    extends JavaScriptObject
    implements Bottom
{


    protected JsoBottom() {
    }

    public final native Number size()
        throws RuntimeException /*-{
        return this["size"] = (this["size"] || {});
    }-*/
    ;

    public final native JsoBottom size(Number size)
        throws RuntimeException /*-{
        this["size"] = size;
        return this;
    }-*/
    ;

}
