
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Bar;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bar.DataLabels;

public class JsoBar
    extends JavaScriptObject
    implements Bar
{


    protected JsoBar() {
    }

    public final native DataLabels dataLabels()
        throws RuntimeException /*-{
        return this["dataLabels"] = (this["dataLabels"] || null);
    }-*/
    ;

    public final native JsoBar dataLabels(DataLabels dataLabels)
        throws RuntimeException /*-{
        this["dataLabels"] = dataLabels;
        return this;
    }-*/
    ;

}
