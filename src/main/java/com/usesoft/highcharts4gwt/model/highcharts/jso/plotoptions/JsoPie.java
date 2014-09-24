
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Pie;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.pie.Events;

public class JsoPie
    extends JavaScriptObject
    implements Pie
{


    protected JsoPie() {
    }

    public final native Number borderWidth()
        throws RuntimeException /*-{
        return this["borderWidth"] = (this["borderWidth"] || 1.0);
    }-*/
    ;

    public final native JsoPie borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native ArrayString center()
        throws RuntimeException /*-{
        return this["center"] = (this["center"] || [null, null]);
    }-*/
    ;

    public final native JsoPie center(ArrayString center)
        throws RuntimeException /*-{
        this["center"] = center;
        return this;
    }-*/
    ;

    public final native Number depth()
        throws RuntimeException /*-{
        return this["depth"] = (this["depth"] || 0.0);
    }-*/
    ;

    public final native JsoPie depth(Number depth)
        throws RuntimeException /*-{
        this["depth"] = depth;
        return this;
    }-*/
    ;

    public final native Number endAngle()
        throws RuntimeException /*-{
        return this["endAngle"] = (this["endAngle"] || null);
    }-*/
    ;

    public final native JsoPie endAngle(Number endAngle)
        throws RuntimeException /*-{
        this["endAngle"] = endAngle;
        return this;
    }-*/
    ;

    public final native Events events()
        throws RuntimeException /*-{
        return this["events"] = (this["events"] || {});
    }-*/
    ;

    public final native JsoPie events(Events events)
        throws RuntimeException /*-{
        this["events"] = events;
        return this;
    }-*/
    ;

    public final native boolean ignoreHiddenPoint()
        throws RuntimeException /*-{
        return this["ignoreHiddenPoint"] = (this["ignoreHiddenPoint"] || true);
    }-*/
    ;

    public final native JsoPie ignoreHiddenPoint(boolean ignoreHiddenPoint)
        throws RuntimeException /*-{
        this["ignoreHiddenPoint"] = ignoreHiddenPoint;
        return this;
    }-*/
    ;

    public final native Number minSize()
        throws RuntimeException /*-{
        return this["minSize"] = (this["minSize"] || 80.0);
    }-*/
    ;

    public final native JsoPie minSize(Number minSize)
        throws RuntimeException /*-{
        this["minSize"] = minSize;
        return this;
    }-*/
    ;

    public final native boolean showInLegend()
        throws RuntimeException /*-{
        return this["showInLegend"] = (this["showInLegend"] || false);
    }-*/
    ;

    public final native JsoPie showInLegend(boolean showInLegend)
        throws RuntimeException /*-{
        this["showInLegend"] = showInLegend;
        return this;
    }-*/
    ;

    public final native Number slicedOffset()
        throws RuntimeException /*-{
        return this["slicedOffset"] = (this["slicedOffset"] || 10.0);
    }-*/
    ;

    public final native JsoPie slicedOffset(Number slicedOffset)
        throws RuntimeException /*-{
        this["slicedOffset"] = slicedOffset;
        return this;
    }-*/
    ;

    public final native Number startAngle()
        throws RuntimeException /*-{
        return this["startAngle"] = (this["startAngle"] || 0.0);
    }-*/
    ;

    public final native JsoPie startAngle(Number startAngle)
        throws RuntimeException /*-{
        this["startAngle"] = startAngle;
        return this;
    }-*/
    ;

    public final native boolean stickyTracking()
        throws RuntimeException /*-{
        return this["stickyTracking"] = (this["stickyTracking"] || false);
    }-*/
    ;

    public final native JsoPie stickyTracking(boolean stickyTracking)
        throws RuntimeException /*-{
        this["stickyTracking"] = stickyTracking;
        return this;
    }-*/
    ;

}
