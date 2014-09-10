
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.pie;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.pie.DataLabels;

public class JsoDataLabels
    extends JavaScriptObject
    implements DataLabels
{


    protected JsoDataLabels() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || {});
    }-*/
    ;

    public final native JsoDataLabels align(String align)
        throws RuntimeException /*-{
        this["align"] = align;
        return this;
    }-*/
    ;

    public final native String connectorColor()
        throws RuntimeException /*-{
        return this["connectorColor"] = (this["connectorColor"] || {});
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
        return this["connectorPadding"] = (this["connectorPadding"] || {});
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
        return this["connectorWidth"] = (this["connectorWidth"] || {});
    }-*/
    ;

    public final native JsoDataLabels connectorWidth(Number connectorWidth)
        throws RuntimeException /*-{
        this["connectorWidth"] = connectorWidth;
        return this;
    }-*/
    ;

    public final native Number distance()
        throws RuntimeException /*-{
        return this["distance"] = (this["distance"] || {});
    }-*/
    ;

    public final native JsoDataLabels distance(Number distance)
        throws RuntimeException /*-{
        this["distance"] = distance;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || {});
    }-*/
    ;

    public final native JsoDataLabels enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native boolean softConnector()
        throws RuntimeException /*-{
        return this["softConnector"] = (this["softConnector"] || {});
    }-*/
    ;

    public final native JsoDataLabels softConnector(boolean softConnector)
        throws RuntimeException /*-{
        this["softConnector"] = softConnector;
        return this;
    }-*/
    ;

}
