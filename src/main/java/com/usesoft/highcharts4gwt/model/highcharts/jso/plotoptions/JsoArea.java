
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Area;

public class JsoArea
    extends JavaScriptObject
    implements Area
{


    protected JsoArea() {
    }

    public final native Number fillOpacity()
        throws RuntimeException /*-{
        return this["fillOpacity"] = (this["fillOpacity"] || {});
    }-*/
    ;

    public final native JsoArea fillOpacity(Number fillOpacity)
        throws RuntimeException /*-{
        this["fillOpacity"] = fillOpacity;
        return this;
    }-*/
    ;

    public final native Number threshold()
        throws RuntimeException /*-{
        return this["threshold"] = (this["threshold"] || {});
    }-*/
    ;

    public final native JsoArea threshold(Number threshold)
        throws RuntimeException /*-{
        this["threshold"] = threshold;
        return this;
    }-*/
    ;

    public final native boolean trackByArea()
        throws RuntimeException /*-{
        return this["trackByArea"] = (this["trackByArea"] || {});
    }-*/
    ;

    public final native JsoArea trackByArea(boolean trackByArea)
        throws RuntimeException /*-{
        this["trackByArea"] = trackByArea;
        return this;
    }-*/
    ;

}
