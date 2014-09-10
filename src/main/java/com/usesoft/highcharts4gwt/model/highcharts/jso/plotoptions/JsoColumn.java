
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Column;

public class JsoColumn
    extends JavaScriptObject
    implements Column
{


    protected JsoColumn() {
    }

    public final native Number borderRadius()
        throws RuntimeException /*-{
        return this["borderRadius"] = (this["borderRadius"] || {});
    }-*/
    ;

    public final native JsoColumn borderRadius(Number borderRadius)
        throws RuntimeException /*-{
        this["borderRadius"] = borderRadius;
        return this;
    }-*/
    ;

    public final native Number borderWidth()
        throws RuntimeException /*-{
        return this["borderWidth"] = (this["borderWidth"] || {});
    }-*/
    ;

    public final native JsoColumn borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native boolean colorByPoint()
        throws RuntimeException /*-{
        return this["colorByPoint"] = (this["colorByPoint"] || {});
    }-*/
    ;

    public final native JsoColumn colorByPoint(boolean colorByPoint)
        throws RuntimeException /*-{
        this["colorByPoint"] = colorByPoint;
        return this;
    }-*/
    ;

    public final native Number cropThreshold()
        throws RuntimeException /*-{
        return this["cropThreshold"] = (this["cropThreshold"] || {});
    }-*/
    ;

    public final native JsoColumn cropThreshold(Number cropThreshold)
        throws RuntimeException /*-{
        this["cropThreshold"] = cropThreshold;
        return this;
    }-*/
    ;

    public final native Number depth()
        throws RuntimeException /*-{
        return this["depth"] = (this["depth"] || {});
    }-*/
    ;

    public final native JsoColumn depth(Number depth)
        throws RuntimeException /*-{
        this["depth"] = depth;
        return this;
    }-*/
    ;

    public final native Number edgeWidth()
        throws RuntimeException /*-{
        return this["edgeWidth"] = (this["edgeWidth"] || {});
    }-*/
    ;

    public final native JsoColumn edgeWidth(Number edgeWidth)
        throws RuntimeException /*-{
        this["edgeWidth"] = edgeWidth;
        return this;
    }-*/
    ;

    public final native Number groupPadding()
        throws RuntimeException /*-{
        return this["groupPadding"] = (this["groupPadding"] || {});
    }-*/
    ;

    public final native JsoColumn groupPadding(Number groupPadding)
        throws RuntimeException /*-{
        this["groupPadding"] = groupPadding;
        return this;
    }-*/
    ;

    public final native Number groupZPadding()
        throws RuntimeException /*-{
        return this["groupZPadding"] = (this["groupZPadding"] || {});
    }-*/
    ;

    public final native JsoColumn groupZPadding(Number groupZPadding)
        throws RuntimeException /*-{
        this["groupZPadding"] = groupZPadding;
        return this;
    }-*/
    ;

    public final native boolean grouping()
        throws RuntimeException /*-{
        return this["grouping"] = (this["grouping"] || {});
    }-*/
    ;

    public final native JsoColumn grouping(boolean grouping)
        throws RuntimeException /*-{
        this["grouping"] = grouping;
        return this;
    }-*/
    ;

    public final native Number minPointLength()
        throws RuntimeException /*-{
        return this["minPointLength"] = (this["minPointLength"] || {});
    }-*/
    ;

    public final native JsoColumn minPointLength(Number minPointLength)
        throws RuntimeException /*-{
        this["minPointLength"] = minPointLength;
        return this;
    }-*/
    ;

    public final native Number pointPadding()
        throws RuntimeException /*-{
        return this["pointPadding"] = (this["pointPadding"] || {});
    }-*/
    ;

    public final native JsoColumn pointPadding(Number pointPadding)
        throws RuntimeException /*-{
        this["pointPadding"] = pointPadding;
        return this;
    }-*/
    ;

    public final native Number pointRange()
        throws RuntimeException /*-{
        return this["pointRange"] = (this["pointRange"] || {});
    }-*/
    ;

    public final native JsoColumn pointRange(Number pointRange)
        throws RuntimeException /*-{
        this["pointRange"] = pointRange;
        return this;
    }-*/
    ;

    public final native Number pointWidth()
        throws RuntimeException /*-{
        return this["pointWidth"] = (this["pointWidth"] || {});
    }-*/
    ;

    public final native JsoColumn pointWidth(Number pointWidth)
        throws RuntimeException /*-{
        this["pointWidth"] = pointWidth;
        return this;
    }-*/
    ;

    public final native Number threshold()
        throws RuntimeException /*-{
        return this["threshold"] = (this["threshold"] || {});
    }-*/
    ;

    public final native JsoColumn threshold(Number threshold)
        throws RuntimeException /*-{
        this["threshold"] = threshold;
        return this;
    }-*/
    ;

}
