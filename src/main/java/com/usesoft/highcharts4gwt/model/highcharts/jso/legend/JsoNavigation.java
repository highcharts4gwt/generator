
package com.usesoft.highcharts4gwt.model.highcharts.jso.legend;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.legend.Navigation;

public class JsoNavigation
    extends JavaScriptObject
    implements Navigation
{


    protected JsoNavigation() {
    }

    public final native Number arrowSize()
        throws RuntimeException /*-{
        return this["arrowSize"] = (this["arrowSize"] || 12.0);
    }-*/
    ;

    public final native JsoNavigation arrowSize(Number arrowSize)
        throws RuntimeException /*-{
        this["arrowSize"] = arrowSize;
        return this;
    }-*/
    ;

}
