
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Bubble;
import com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.JsoScatter;

public class JsoBubble
    extends JsoScatter
    implements Bubble
{


    protected JsoBubble() {
    }

    public final native boolean displayNegative()
        throws RuntimeException /*-{
        return this["displayNegative"] = (this["displayNegative"] || true);
    }-*/
    ;

    public final native JsoBubble displayNegative(boolean displayNegative)
        throws RuntimeException /*-{
        this["displayNegative"] = displayNegative;
        return this;
    }-*/
    ;

    public final native String maxSize()
        throws RuntimeException /*-{
        return this["maxSize"] = (this["maxSize"] || "20%");
    }-*/
    ;

    public final native JsoBubble maxSize(String maxSize)
        throws RuntimeException /*-{
        this["maxSize"] = maxSize;
        return this;
    }-*/
    ;

    public final native String minSize()
        throws RuntimeException /*-{
        return this["minSize"] = (this["minSize"] || "8");
    }-*/
    ;

    public final native JsoBubble minSize(String minSize)
        throws RuntimeException /*-{
        this["minSize"] = minSize;
        return this;
    }-*/
    ;

    public final native String sizeBy()
        throws RuntimeException /*-{
        return this["sizeBy"] = (this["sizeBy"] || "area");
    }-*/
    ;

    public final native JsoBubble sizeBy(String sizeBy)
        throws RuntimeException /*-{
        this["sizeBy"] = sizeBy;
        return this;
    }-*/
    ;

    public final native Number zMax()
        throws RuntimeException /*-{
        return this["zMax"] = (this["zMax"] || null);
    }-*/
    ;

    public final native JsoBubble zMax(Number zMax)
        throws RuntimeException /*-{
        this["zMax"] = zMax;
        return this;
    }-*/
    ;

    public final native Number zMin()
        throws RuntimeException /*-{
        return this["zMin"] = (this["zMin"] || null);
    }-*/
    ;

    public final native JsoBubble zMin(Number zMin)
        throws RuntimeException /*-{
        this["zMin"] = zMin;
        return this;
    }-*/
    ;

    public final native Number zThreshold()
        throws RuntimeException /*-{
        return this["zThreshold"] = (this["zThreshold"] || 0.0);
    }-*/
    ;

    public final native JsoBubble zThreshold(Number zThreshold)
        throws RuntimeException /*-{
        this["zThreshold"] = zThreshold;
        return this;
    }-*/
    ;

}
