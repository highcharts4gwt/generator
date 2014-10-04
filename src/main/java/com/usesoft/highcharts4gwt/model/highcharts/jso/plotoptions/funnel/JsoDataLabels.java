
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.funnel;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.funnel.DataLabels;

public class JsoDataLabels
    extends com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.series.JsoDataLabels
    implements DataLabels
{


    protected JsoDataLabels() {
    }

    public final native String connectorColor()
        throws RuntimeException /*-{
        return this["connectorColor"] = (this["connectorColor"] || "{point.color}");
    }-*/
    ;

    public final native JsoDataLabels connectorColor(String connectorColor)
        throws RuntimeException /*-{
        this["connectorColor"] = connectorColor;
        return this;
    }-*/
    ;

    public final native Number connectorPadding()
        throws RuntimeException /*-{
        return this["connectorPadding"] = (this["connectorPadding"] || 5.0);
    }-*/
    ;

    public final native JsoDataLabels connectorPadding(Number connectorPadding)
        throws RuntimeException /*-{
        this["connectorPadding"] = connectorPadding;
        return this;
    }-*/
    ;

    public final native Number connectorWidth()
        throws RuntimeException /*-{
        return this["connectorWidth"] = (this["connectorWidth"] || 1.0);
    }-*/
    ;

    public final native JsoDataLabels connectorWidth(Number connectorWidth)
        throws RuntimeException /*-{
        this["connectorWidth"] = connectorWidth;
        return this;
    }-*/
    ;

    public final native boolean softConnector()
        throws RuntimeException /*-{
        return this["softConnector"] = (this["softConnector"] || true);
    }-*/
    ;

    public final native JsoDataLabels softConnector(boolean softConnector)
        throws RuntimeException /*-{
        this["softConnector"] = softConnector;
        return this;
    }-*/
    ;

}
