
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Pie;
import com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.JsoSeries;

public class JsoPie
    extends JsoSeries
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

}
