
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.YAxis;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Events;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Labels;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.PlotBands;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.PlotLines;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.StackLabels;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Title;

public class JsoYAxis
    extends JavaScriptObject
    implements YAxis
{


    protected JsoYAxis() {
    }

    public final native boolean endOnTick()
        throws RuntimeException /*-{
        return this["endOnTick"] = (this["endOnTick"] || true);
    }-*/
    ;

    public final native JsoYAxis endOnTick(boolean endOnTick)
        throws RuntimeException /*-{
        this["endOnTick"] = endOnTick;
        return this;
    }-*/
    ;

    public final native Events events()
        throws RuntimeException /*-{
        return this["events"] = (this["events"] || {});
    }-*/
    ;

    public final native JsoYAxis events(Events events)
        throws RuntimeException /*-{
        this["events"] = events;
        return this;
    }-*/
    ;

    public final native String gridLineInterpolation()
        throws RuntimeException /*-{
        return this["gridLineInterpolation"] = (this["gridLineInterpolation"] || "null");
    }-*/
    ;

    public final native JsoYAxis gridLineInterpolation(String gridLineInterpolation)
        throws RuntimeException /*-{
        this["gridLineInterpolation"] = gridLineInterpolation;
        return this;
    }-*/
    ;

    public final native Number gridLineWidth()
        throws RuntimeException /*-{
        return this["gridLineWidth"] = (this["gridLineWidth"] || 1.0);
    }-*/
    ;

    public final native JsoYAxis gridLineWidth(Number gridLineWidth)
        throws RuntimeException /*-{
        this["gridLineWidth"] = gridLineWidth;
        return this;
    }-*/
    ;

    public final native Labels labels()
        throws RuntimeException /*-{
        return this["labels"] = (this["labels"] || {});
    }-*/
    ;

    public final native JsoYAxis labels(Labels labels)
        throws RuntimeException /*-{
        this["labels"] = labels;
        return this;
    }-*/
    ;

    public final native Number lineWidth()
        throws RuntimeException /*-{
        return this["lineWidth"] = (this["lineWidth"] || 0.0);
    }-*/
    ;

    public final native JsoYAxis lineWidth(Number lineWidth)
        throws RuntimeException /*-{
        this["lineWidth"] = lineWidth;
        return this;
    }-*/
    ;

    public final native Number maxPadding()
        throws RuntimeException /*-{
        return this["maxPadding"] = (this["maxPadding"] || 0.05);
    }-*/
    ;

    public final native JsoYAxis maxPadding(Number maxPadding)
        throws RuntimeException /*-{
        this["maxPadding"] = maxPadding;
        return this;
    }-*/
    ;

    public final native Number minPadding()
        throws RuntimeException /*-{
        return this["minPadding"] = (this["minPadding"] || 0.05);
    }-*/
    ;

    public final native JsoYAxis minPadding(Number minPadding)
        throws RuntimeException /*-{
        this["minPadding"] = minPadding;
        return this;
    }-*/
    ;

    public final native Array<PlotBands> plotBands()
        throws RuntimeException /*-{
        return this["plotBands"] = (this["plotBands"] || null);
    }-*/
    ;

    public final native JsoYAxis plotBands(Array<PlotBands> plotBands)
        throws RuntimeException /*-{
        this["plotBands"] = plotBands;
        return this;
    }-*/
    ;

    public final native Array<PlotLines> plotLines()
        throws RuntimeException /*-{
        return this["plotLines"] = (this["plotLines"] || null);
    }-*/
    ;

    public final native JsoYAxis plotLines(Array<PlotLines> plotLines)
        throws RuntimeException /*-{
        this["plotLines"] = plotLines;
        return this;
    }-*/
    ;

    public final native boolean reversedStacks()
        throws RuntimeException /*-{
        return this["reversedStacks"] = (this["reversedStacks"] || true);
    }-*/
    ;

    public final native JsoYAxis reversedStacks(boolean reversedStacks)
        throws RuntimeException /*-{
        this["reversedStacks"] = reversedStacks;
        return this;
    }-*/
    ;

    public final native boolean showLastLabel()
        throws RuntimeException /*-{
        return this["showLastLabel"] = (this["showLastLabel"] || true);
    }-*/
    ;

    public final native JsoYAxis showLastLabel(boolean showLastLabel)
        throws RuntimeException /*-{
        this["showLastLabel"] = showLastLabel;
        return this;
    }-*/
    ;

    public final native StackLabels stackLabels()
        throws RuntimeException /*-{
        return this["stackLabels"] = (this["stackLabels"] || {});
    }-*/
    ;

    public final native JsoYAxis stackLabels(StackLabels stackLabels)
        throws RuntimeException /*-{
        this["stackLabels"] = stackLabels;
        return this;
    }-*/
    ;

    public final native boolean startOnTick()
        throws RuntimeException /*-{
        return this["startOnTick"] = (this["startOnTick"] || true);
    }-*/
    ;

    public final native JsoYAxis startOnTick(boolean startOnTick)
        throws RuntimeException /*-{
        this["startOnTick"] = startOnTick;
        return this;
    }-*/
    ;

    public final native Number tickWidth()
        throws RuntimeException /*-{
        return this["tickWidth"] = (this["tickWidth"] || 0.0);
    }-*/
    ;

    public final native JsoYAxis tickWidth(Number tickWidth)
        throws RuntimeException /*-{
        this["tickWidth"] = tickWidth;
        return this;
    }-*/
    ;

    public final native Title title()
        throws RuntimeException /*-{
        return this["title"] = (this["title"] || {});
    }-*/
    ;

    public final native JsoYAxis title(Title title)
        throws RuntimeException /*-{
        this["title"] = title;
        return this;
    }-*/
    ;

}
