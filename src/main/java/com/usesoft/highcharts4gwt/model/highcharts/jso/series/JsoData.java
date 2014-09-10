
package com.usesoft.highcharts4gwt.model.highcharts.jso.series;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.series.Data;
import com.usesoft.highcharts4gwt.model.highcharts.api.series.data.Marker;

public class JsoData
    extends JavaScriptObject
    implements Data
{


    protected JsoData() {
    }

    public final native String drilldown()
        throws RuntimeException /*-{
        return this["drilldown"] = (this["drilldown"] || {});
    }-*/
    ;

    public final native JsoData drilldown(String drilldown)
        throws RuntimeException /*-{
        this["drilldown"] = drilldown;
        return this;
    }-*/
    ;

    public final native String id()
        throws RuntimeException /*-{
        return this["id"] = (this["id"] || {});
    }-*/
    ;

    public final native JsoData id(String id)
        throws RuntimeException /*-{
        this["id"] = id;
        return this;
    }-*/
    ;

    public final native boolean isIntermediateSum()
        throws RuntimeException /*-{
        return this["isIntermediateSum"] = (this["isIntermediateSum"] || {});
    }-*/
    ;

    public final native JsoData isIntermediateSum(boolean isIntermediateSum)
        throws RuntimeException /*-{
        this["isIntermediateSum"] = isIntermediateSum;
        return this;
    }-*/
    ;

    public final native boolean isSum()
        throws RuntimeException /*-{
        return this["isSum"] = (this["isSum"] || {});
    }-*/
    ;

    public final native JsoData isSum(boolean isSum)
        throws RuntimeException /*-{
        this["isSum"] = isSum;
        return this;
    }-*/
    ;

    public final native Number legendIndex()
        throws RuntimeException /*-{
        return this["legendIndex"] = (this["legendIndex"] || {});
    }-*/
    ;

    public final native JsoData legendIndex(Number legendIndex)
        throws RuntimeException /*-{
        this["legendIndex"] = legendIndex;
        return this;
    }-*/
    ;

    public final native Marker marker()
        throws RuntimeException /*-{
        return this["marker"] = (this["marker"] || {});
    }-*/
    ;

    public final native JsoData marker(Marker marker)
        throws RuntimeException /*-{
        this["marker"] = marker;
        return this;
    }-*/
    ;

    public final native String name()
        throws RuntimeException /*-{
        return this["name"] = (this["name"] || {});
    }-*/
    ;

    public final native JsoData name(String name)
        throws RuntimeException /*-{
        this["name"] = name;
        return this;
    }-*/
    ;

    public final native boolean sliced()
        throws RuntimeException /*-{
        return this["sliced"] = (this["sliced"] || {});
    }-*/
    ;

    public final native JsoData sliced(boolean sliced)
        throws RuntimeException /*-{
        this["sliced"] = sliced;
        return this;
    }-*/
    ;

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || {});
    }-*/
    ;

    public final native JsoData x(Number x)
        throws RuntimeException /*-{
        this["x"] = x;
        return this;
    }-*/
    ;

    public final native Number y()
        throws RuntimeException /*-{
        return this["y"] = (this["y"] || {});
    }-*/
    ;

    public final native JsoData y(Number y)
        throws RuntimeException /*-{
        this["y"] = y;
        return this;
    }-*/
    ;

}
