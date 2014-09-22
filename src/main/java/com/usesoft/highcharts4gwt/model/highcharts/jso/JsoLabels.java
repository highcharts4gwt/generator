
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.Labels;

public class JsoLabels
    extends JavaScriptObject
    implements Labels
{


    protected JsoLabels() {
    }

    public final native Array<JsoLabels> items()
        throws RuntimeException /*-{
        return this["items"] = (this["items"] || null);
    }-*/
    ;

    public final native JsoLabels items(Array<JsoLabels> items)
        throws RuntimeException /*-{
        this["items"] = items;
        return this;
    }-*/
    ;

}
