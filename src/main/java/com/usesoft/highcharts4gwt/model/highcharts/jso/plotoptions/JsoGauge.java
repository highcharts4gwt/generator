
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Gauge;

public class JsoGauge
    extends JavaScriptObject
    implements Gauge
{


    protected JsoGauge() {
    }

    public final native Number overshoot()
        throws RuntimeException /*-{
        return this["overshoot"] = (this["overshoot"] || {});
    }-*/
    ;

    public final native JsoGauge overshoot(Number overshoot)
        throws RuntimeException /*-{
        this["overshoot"] = overshoot;
        return this;
    }-*/
    ;

    public final native boolean showInLegend()
        throws RuntimeException /*-{
        return this["showInLegend"] = (this["showInLegend"] || {});
    }-*/
    ;

    public final native JsoGauge showInLegend(boolean showInLegend)
        throws RuntimeException /*-{
        this["showInLegend"] = showInLegend;
        return this;
    }-*/
    ;

    public final native boolean wrap()
        throws RuntimeException /*-{
        return this["wrap"] = (this["wrap"] || {});
    }-*/
    ;

    public final native JsoGauge wrap(boolean wrap)
        throws RuntimeException /*-{
        this["wrap"] = wrap;
        return this;
    }-*/
    ;

}
