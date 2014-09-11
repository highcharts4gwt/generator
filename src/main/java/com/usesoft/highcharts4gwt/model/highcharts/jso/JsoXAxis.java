
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.XAxis;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Events;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Labels;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotBands;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotLines;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Title;

public class JsoXAxis
    extends JavaScriptObject
    implements XAxis
{


    protected JsoXAxis() {
    }

    public final native boolean allowDecimals()
        throws RuntimeException /*-{
        return this["allowDecimals"] = (this["allowDecimals"] || {});
    }-*/
    ;

    public final native JsoXAxis allowDecimals(boolean allowDecimals)
        throws RuntimeException /*-{
        this["allowDecimals"] = allowDecimals;
        return this;
    }-*/
    ;

    public final native Number ceiling()
        throws RuntimeException /*-{
        return this["ceiling"] = (this["ceiling"] || {});
    }-*/
    ;

    public final native JsoXAxis ceiling(Number ceiling)
        throws RuntimeException /*-{
        this["ceiling"] = ceiling;
        return this;
    }-*/
    ;

    public final native boolean endOnTick()
        throws RuntimeException /*-{
        return this["endOnTick"] = (this["endOnTick"] || {});
    }-*/
    ;

    public final native JsoXAxis endOnTick(boolean endOnTick)
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

    public final native JsoXAxis events(Events events)
        throws RuntimeException /*-{
        this["events"] = events;
        return this;
    }-*/
    ;

    public final native Number floor()
        throws RuntimeException /*-{
        return this["floor"] = (this["floor"] || {});
    }-*/
    ;

    public final native JsoXAxis floor(Number floor)
        throws RuntimeException /*-{
        this["floor"] = floor;
        return this;
    }-*/
    ;

    public final native String gridLineDashStyle()
        throws RuntimeException /*-{
        return this["gridLineDashStyle"] = (this["gridLineDashStyle"] || {});
    }-*/
    ;

    public final native JsoXAxis gridLineDashStyle(String gridLineDashStyle)
        throws RuntimeException /*-{
        this["gridLineDashStyle"] = gridLineDashStyle;
        return this;
    }-*/
    ;

    public final native Number gridLineWidth()
        throws RuntimeException /*-{
        return this["gridLineWidth"] = (this["gridLineWidth"] || {});
    }-*/
    ;

    public final native JsoXAxis gridLineWidth(Number gridLineWidth)
        throws RuntimeException /*-{
        this["gridLineWidth"] = gridLineWidth;
        return this;
    }-*/
    ;

    public final native Number gridZIndex()
        throws RuntimeException /*-{
        return this["gridZIndex"] = (this["gridZIndex"] || {});
    }-*/
    ;

    public final native JsoXAxis gridZIndex(Number gridZIndex)
        throws RuntimeException /*-{
        this["gridZIndex"] = gridZIndex;
        return this;
    }-*/
    ;

    public final native String id()
        throws RuntimeException /*-{
        return this["id"] = (this["id"] || {});
    }-*/
    ;

    public final native JsoXAxis id(String id)
        throws RuntimeException /*-{
        this["id"] = id;
        return this;
    }-*/
    ;

    public final native Labels labels()
        throws RuntimeException /*-{
        return this["labels"] = (this["labels"] || {});
    }-*/
    ;

    public final native JsoXAxis labels(Labels labels)
        throws RuntimeException /*-{
        this["labels"] = labels;
        return this;
    }-*/
    ;

    public final native Number lineWidth()
        throws RuntimeException /*-{
        return this["lineWidth"] = (this["lineWidth"] || {});
    }-*/
    ;

    public final native JsoXAxis lineWidth(Number lineWidth)
        throws RuntimeException /*-{
        this["lineWidth"] = lineWidth;
        return this;
    }-*/
    ;

    public final native Number linkedTo()
        throws RuntimeException /*-{
        return this["linkedTo"] = (this["linkedTo"] || {});
    }-*/
    ;

    public final native JsoXAxis linkedTo(Number linkedTo)
        throws RuntimeException /*-{
        this["linkedTo"] = linkedTo;
        return this;
    }-*/
    ;

    public final native Number max()
        throws RuntimeException /*-{
        return this["max"] = (this["max"] || {});
    }-*/
    ;

    public final native JsoXAxis max(Number max)
        throws RuntimeException /*-{
        this["max"] = max;
        return this;
    }-*/
    ;

    public final native Number maxPadding()
        throws RuntimeException /*-{
        return this["maxPadding"] = (this["maxPadding"] || {});
    }-*/
    ;

    public final native JsoXAxis maxPadding(Number maxPadding)
        throws RuntimeException /*-{
        this["maxPadding"] = maxPadding;
        return this;
    }-*/
    ;

    public final native Number maxZoom()
        throws RuntimeException /*-{
        return this["maxZoom"] = (this["maxZoom"] || {});
    }-*/
    ;

    public final native JsoXAxis maxZoom(Number maxZoom)
        throws RuntimeException /*-{
        this["maxZoom"] = maxZoom;
        return this;
    }-*/
    ;

    public final native Number min()
        throws RuntimeException /*-{
        return this["min"] = (this["min"] || {});
    }-*/
    ;

    public final native JsoXAxis min(Number min)
        throws RuntimeException /*-{
        this["min"] = min;
        return this;
    }-*/
    ;

    public final native Number minPadding()
        throws RuntimeException /*-{
        return this["minPadding"] = (this["minPadding"] || {});
    }-*/
    ;

    public final native JsoXAxis minPadding(Number minPadding)
        throws RuntimeException /*-{
        this["minPadding"] = minPadding;
        return this;
    }-*/
    ;

    public final native Number minRange()
        throws RuntimeException /*-{
        return this["minRange"] = (this["minRange"] || {});
    }-*/
    ;

    public final native JsoXAxis minRange(Number minRange)
        throws RuntimeException /*-{
        this["minRange"] = minRange;
        return this;
    }-*/
    ;

    public final native Number minTickInterval()
        throws RuntimeException /*-{
        return this["minTickInterval"] = (this["minTickInterval"] || {});
    }-*/
    ;

    public final native JsoXAxis minTickInterval(Number minTickInterval)
        throws RuntimeException /*-{
        this["minTickInterval"] = minTickInterval;
        return this;
    }-*/
    ;

    public final native String minorGridLineDashStyle()
        throws RuntimeException /*-{
        return this["minorGridLineDashStyle"] = (this["minorGridLineDashStyle"] || {});
    }-*/
    ;

    public final native JsoXAxis minorGridLineDashStyle(String minorGridLineDashStyle)
        throws RuntimeException /*-{
        this["minorGridLineDashStyle"] = minorGridLineDashStyle;
        return this;
    }-*/
    ;

    public final native Number minorGridLineWidth()
        throws RuntimeException /*-{
        return this["minorGridLineWidth"] = (this["minorGridLineWidth"] || {});
    }-*/
    ;

    public final native JsoXAxis minorGridLineWidth(Number minorGridLineWidth)
        throws RuntimeException /*-{
        this["minorGridLineWidth"] = minorGridLineWidth;
        return this;
    }-*/
    ;

    public final native Number minorTickInterval()
        throws RuntimeException /*-{
        return this["minorTickInterval"] = (this["minorTickInterval"] || {});
    }-*/
    ;

    public final native JsoXAxis minorTickInterval(Number minorTickInterval)
        throws RuntimeException /*-{
        this["minorTickInterval"] = minorTickInterval;
        return this;
    }-*/
    ;

    public final native Number minorTickLength()
        throws RuntimeException /*-{
        return this["minorTickLength"] = (this["minorTickLength"] || {});
    }-*/
    ;

    public final native JsoXAxis minorTickLength(Number minorTickLength)
        throws RuntimeException /*-{
        this["minorTickLength"] = minorTickLength;
        return this;
    }-*/
    ;

    public final native String minorTickPosition()
        throws RuntimeException /*-{
        return this["minorTickPosition"] = (this["minorTickPosition"] || {});
    }-*/
    ;

    public final native JsoXAxis minorTickPosition(String minorTickPosition)
        throws RuntimeException /*-{
        this["minorTickPosition"] = minorTickPosition;
        return this;
    }-*/
    ;

    public final native Number minorTickWidth()
        throws RuntimeException /*-{
        return this["minorTickWidth"] = (this["minorTickWidth"] || {});
    }-*/
    ;

    public final native JsoXAxis minorTickWidth(Number minorTickWidth)
        throws RuntimeException /*-{
        this["minorTickWidth"] = minorTickWidth;
        return this;
    }-*/
    ;

    public final native Number offset()
        throws RuntimeException /*-{
        return this["offset"] = (this["offset"] || {});
    }-*/
    ;

    public final native JsoXAxis offset(Number offset)
        throws RuntimeException /*-{
        this["offset"] = offset;
        return this;
    }-*/
    ;

    public final native boolean opposite()
        throws RuntimeException /*-{
        return this["opposite"] = (this["opposite"] || {});
    }-*/
    ;

    public final native JsoXAxis opposite(boolean opposite)
        throws RuntimeException /*-{
        this["opposite"] = opposite;
        return this;
    }-*/
    ;

    public final native Array<PlotBands> plotBands()
        throws RuntimeException /*-{
        return this["plotBands"] = (this["plotBands"] || []);
    }-*/
    ;

    public final native JsoXAxis plotBands(Array<PlotBands> plotBands)
        throws RuntimeException /*-{
        this["plotBands"] = plotBands;
        return this;
    }-*/
    ;

    public final native Array<PlotLines> plotLines()
        throws RuntimeException /*-{
        return this["plotLines"] = (this["plotLines"] || []);
    }-*/
    ;

    public final native JsoXAxis plotLines(Array<PlotLines> plotLines)
        throws RuntimeException /*-{
        this["plotLines"] = plotLines;
        return this;
    }-*/
    ;

    public final native boolean reversed()
        throws RuntimeException /*-{
        return this["reversed"] = (this["reversed"] || {});
    }-*/
    ;

    public final native JsoXAxis reversed(boolean reversed)
        throws RuntimeException /*-{
        this["reversed"] = reversed;
        return this;
    }-*/
    ;

    public final native boolean showEmpty()
        throws RuntimeException /*-{
        return this["showEmpty"] = (this["showEmpty"] || {});
    }-*/
    ;

    public final native JsoXAxis showEmpty(boolean showEmpty)
        throws RuntimeException /*-{
        this["showEmpty"] = showEmpty;
        return this;
    }-*/
    ;

    public final native boolean showFirstLabel()
        throws RuntimeException /*-{
        return this["showFirstLabel"] = (this["showFirstLabel"] || {});
    }-*/
    ;

    public final native JsoXAxis showFirstLabel(boolean showFirstLabel)
        throws RuntimeException /*-{
        this["showFirstLabel"] = showFirstLabel;
        return this;
    }-*/
    ;

    public final native boolean showLastLabel()
        throws RuntimeException /*-{
        return this["showLastLabel"] = (this["showLastLabel"] || {});
    }-*/
    ;

    public final native JsoXAxis showLastLabel(boolean showLastLabel)
        throws RuntimeException /*-{
        this["showLastLabel"] = showLastLabel;
        return this;
    }-*/
    ;

    public final native Number startOfWeek()
        throws RuntimeException /*-{
        return this["startOfWeek"] = (this["startOfWeek"] || {});
    }-*/
    ;

    public final native JsoXAxis startOfWeek(Number startOfWeek)
        throws RuntimeException /*-{
        this["startOfWeek"] = startOfWeek;
        return this;
    }-*/
    ;

    public final native boolean startOnTick()
        throws RuntimeException /*-{
        return this["startOnTick"] = (this["startOnTick"] || {});
    }-*/
    ;

    public final native JsoXAxis startOnTick(boolean startOnTick)
        throws RuntimeException /*-{
        this["startOnTick"] = startOnTick;
        return this;
    }-*/
    ;

    public final native Number tickInterval()
        throws RuntimeException /*-{
        return this["tickInterval"] = (this["tickInterval"] || {});
    }-*/
    ;

    public final native JsoXAxis tickInterval(Number tickInterval)
        throws RuntimeException /*-{
        this["tickInterval"] = tickInterval;
        return this;
    }-*/
    ;

    public final native Number tickLength()
        throws RuntimeException /*-{
        return this["tickLength"] = (this["tickLength"] || {});
    }-*/
    ;

    public final native JsoXAxis tickLength(Number tickLength)
        throws RuntimeException /*-{
        this["tickLength"] = tickLength;
        return this;
    }-*/
    ;

    public final native Number tickPixelInterval()
        throws RuntimeException /*-{
        return this["tickPixelInterval"] = (this["tickPixelInterval"] || {});
    }-*/
    ;

    public final native JsoXAxis tickPixelInterval(Number tickPixelInterval)
        throws RuntimeException /*-{
        this["tickPixelInterval"] = tickPixelInterval;
        return this;
    }-*/
    ;

    public final native String tickPosition()
        throws RuntimeException /*-{
        return this["tickPosition"] = (this["tickPosition"] || {});
    }-*/
    ;

    public final native JsoXAxis tickPosition(String tickPosition)
        throws RuntimeException /*-{
        this["tickPosition"] = tickPosition;
        return this;
    }-*/
    ;

    public final native Number tickWidth()
        throws RuntimeException /*-{
        return this["tickWidth"] = (this["tickWidth"] || {});
    }-*/
    ;

    public final native JsoXAxis tickWidth(Number tickWidth)
        throws RuntimeException /*-{
        this["tickWidth"] = tickWidth;
        return this;
    }-*/
    ;

    public final native String tickmarkPlacement()
        throws RuntimeException /*-{
        return this["tickmarkPlacement"] = (this["tickmarkPlacement"] || {});
    }-*/
    ;

    public final native JsoXAxis tickmarkPlacement(String tickmarkPlacement)
        throws RuntimeException /*-{
        this["tickmarkPlacement"] = tickmarkPlacement;
        return this;
    }-*/
    ;

    public final native Title title()
        throws RuntimeException /*-{
        return this["title"] = (this["title"] || {});
    }-*/
    ;

    public final native JsoXAxis title(Title title)
        throws RuntimeException /*-{
        this["title"] = title;
        return this;
    }-*/
    ;

    public final native String type()
        throws RuntimeException /*-{
        return this["type"] = (this["type"] || {});
    }-*/
    ;

    public final native JsoXAxis type(String type)
        throws RuntimeException /*-{
        this["type"] = type;
        return this;
    }-*/
    ;

}
