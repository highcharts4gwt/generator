
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.highcharts.api.Chart;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.Events;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.Options3d;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.ResetZoomButton;

public class JsoChart
    extends JavaScriptObject
    implements Chart
{


    protected JsoChart() {
    }

    public final native boolean alignTicks()
        throws RuntimeException /*-{
        return this["alignTicks"] = (this["alignTicks"] || true);
    }-*/
    ;

    public final native JsoChart alignTicks(boolean alignTicks)
        throws RuntimeException /*-{
        this["alignTicks"] = alignTicks;
        return this;
    }-*/
    ;

    public final native Number borderRadius()
        throws RuntimeException /*-{
        return this["borderRadius"] = (this["borderRadius"] || 0.0);
    }-*/
    ;

    public final native JsoChart borderRadius(Number borderRadius)
        throws RuntimeException /*-{
        this["borderRadius"] = borderRadius;
        return this;
    }-*/
    ;

    public final native Number borderWidth()
        throws RuntimeException /*-{
        return this["borderWidth"] = (this["borderWidth"] || 0.0);
    }-*/
    ;

    public final native JsoChart borderWidth(Number borderWidth)
        throws RuntimeException /*-{
        this["borderWidth"] = borderWidth;
        return this;
    }-*/
    ;

    public final native String className()
        throws RuntimeException /*-{
        return this["className"] = (this["className"] || "null");
    }-*/
    ;

    public final native JsoChart className(String className)
        throws RuntimeException /*-{
        this["className"] = className;
        return this;
    }-*/
    ;

    public final native String defaultSeriesType()
        throws RuntimeException /*-{
        return this["defaultSeriesType"] = (this["defaultSeriesType"] || "line");
    }-*/
    ;

    public final native JsoChart defaultSeriesType(String defaultSeriesType)
        throws RuntimeException /*-{
        this["defaultSeriesType"] = defaultSeriesType;
        return this;
    }-*/
    ;

    public final native Events events()
        throws RuntimeException /*-{
        return this["events"] = (this["events"] || null);
    }-*/
    ;

    public final native JsoChart events(Events events)
        throws RuntimeException /*-{
        this["events"] = events;
        return this;
    }-*/
    ;

    public final native Number height()
        throws RuntimeException /*-{
        return this["height"] = (this["height"] || null);
    }-*/
    ;

    public final native JsoChart height(Number height)
        throws RuntimeException /*-{
        this["height"] = height;
        return this;
    }-*/
    ;

    public final native boolean ignoreHiddenSeries()
        throws RuntimeException /*-{
        return this["ignoreHiddenSeries"] = (this["ignoreHiddenSeries"] || true);
    }-*/
    ;

    public final native JsoChart ignoreHiddenSeries(boolean ignoreHiddenSeries)
        throws RuntimeException /*-{
        this["ignoreHiddenSeries"] = ignoreHiddenSeries;
        return this;
    }-*/
    ;

    public final native boolean inverted()
        throws RuntimeException /*-{
        return this["inverted"] = (this["inverted"] || false);
    }-*/
    ;

    public final native JsoChart inverted(boolean inverted)
        throws RuntimeException /*-{
        this["inverted"] = inverted;
        return this;
    }-*/
    ;

    public final native Number marginBottom()
        throws RuntimeException /*-{
        return this["marginBottom"] = (this["marginBottom"] || null);
    }-*/
    ;

    public final native JsoChart marginBottom(Number marginBottom)
        throws RuntimeException /*-{
        this["marginBottom"] = marginBottom;
        return this;
    }-*/
    ;

    public final native Number marginLeft()
        throws RuntimeException /*-{
        return this["marginLeft"] = (this["marginLeft"] || null);
    }-*/
    ;

    public final native JsoChart marginLeft(Number marginLeft)
        throws RuntimeException /*-{
        this["marginLeft"] = marginLeft;
        return this;
    }-*/
    ;

    public final native Number marginRight()
        throws RuntimeException /*-{
        return this["marginRight"] = (this["marginRight"] || null);
    }-*/
    ;

    public final native JsoChart marginRight(Number marginRight)
        throws RuntimeException /*-{
        this["marginRight"] = marginRight;
        return this;
    }-*/
    ;

    public final native Number marginTop()
        throws RuntimeException /*-{
        return this["marginTop"] = (this["marginTop"] || null);
    }-*/
    ;

    public final native JsoChart marginTop(Number marginTop)
        throws RuntimeException /*-{
        this["marginTop"] = marginTop;
        return this;
    }-*/
    ;

    public final native Options3d options3d()
        throws RuntimeException /*-{
        return this["options3d"] = (this["options3d"] || null);
    }-*/
    ;

    public final native JsoChart options3d(Options3d options3d)
        throws RuntimeException /*-{
        this["options3d"] = options3d;
        return this;
    }-*/
    ;

    public final native String panKey()
        throws RuntimeException /*-{
        return this["panKey"] = (this["panKey"] || "");
    }-*/
    ;

    public final native JsoChart panKey(String panKey)
        throws RuntimeException /*-{
        this["panKey"] = panKey;
        return this;
    }-*/
    ;

    public final native boolean panning()
        throws RuntimeException /*-{
        return this["panning"] = (this["panning"] || false);
    }-*/
    ;

    public final native JsoChart panning(boolean panning)
        throws RuntimeException /*-{
        this["panning"] = panning;
        return this;
    }-*/
    ;

    public final native String pinchType()
        throws RuntimeException /*-{
        return this["pinchType"] = (this["pinchType"] || "null");
    }-*/
    ;

    public final native JsoChart pinchType(String pinchType)
        throws RuntimeException /*-{
        this["pinchType"] = pinchType;
        return this;
    }-*/
    ;

    public final native String plotBackgroundImage()
        throws RuntimeException /*-{
        return this["plotBackgroundImage"] = (this["plotBackgroundImage"] || "null");
    }-*/
    ;

    public final native JsoChart plotBackgroundImage(String plotBackgroundImage)
        throws RuntimeException /*-{
        this["plotBackgroundImage"] = plotBackgroundImage;
        return this;
    }-*/
    ;

    public final native Number plotBorderWidth()
        throws RuntimeException /*-{
        return this["plotBorderWidth"] = (this["plotBorderWidth"] || 0.0);
    }-*/
    ;

    public final native JsoChart plotBorderWidth(Number plotBorderWidth)
        throws RuntimeException /*-{
        this["plotBorderWidth"] = plotBorderWidth;
        return this;
    }-*/
    ;

    public final native boolean polar()
        throws RuntimeException /*-{
        return this["polar"] = (this["polar"] || false);
    }-*/
    ;

    public final native JsoChart polar(boolean polar)
        throws RuntimeException /*-{
        this["polar"] = polar;
        return this;
    }-*/
    ;

    public final native boolean reflow()
        throws RuntimeException /*-{
        return this["reflow"] = (this["reflow"] || true);
    }-*/
    ;

    public final native JsoChart reflow(boolean reflow)
        throws RuntimeException /*-{
        this["reflow"] = reflow;
        return this;
    }-*/
    ;

    public final native ResetZoomButton resetZoomButton()
        throws RuntimeException /*-{
        return this["resetZoomButton"] = (this["resetZoomButton"] || null);
    }-*/
    ;

    public final native JsoChart resetZoomButton(ResetZoomButton resetZoomButton)
        throws RuntimeException /*-{
        this["resetZoomButton"] = resetZoomButton;
        return this;
    }-*/
    ;

    public final native boolean showAxes()
        throws RuntimeException /*-{
        return this["showAxes"] = (this["showAxes"] || false);
    }-*/
    ;

    public final native JsoChart showAxes(boolean showAxes)
        throws RuntimeException /*-{
        this["showAxes"] = showAxes;
        return this;
    }-*/
    ;

    public final native ArrayNumber spacing()
        throws RuntimeException /*-{
        return this["spacing"] = (this["spacing"] || [10, 10, 15, 10]);
    }-*/
    ;

    public final native JsoChart spacing(ArrayNumber spacing)
        throws RuntimeException /*-{
        this["spacing"] = spacing;
        return this;
    }-*/
    ;

    public final native Number spacingBottom()
        throws RuntimeException /*-{
        return this["spacingBottom"] = (this["spacingBottom"] || 15.0);
    }-*/
    ;

    public final native JsoChart spacingBottom(Number spacingBottom)
        throws RuntimeException /*-{
        this["spacingBottom"] = spacingBottom;
        return this;
    }-*/
    ;

    public final native Number spacingLeft()
        throws RuntimeException /*-{
        return this["spacingLeft"] = (this["spacingLeft"] || 10.0);
    }-*/
    ;

    public final native JsoChart spacingLeft(Number spacingLeft)
        throws RuntimeException /*-{
        this["spacingLeft"] = spacingLeft;
        return this;
    }-*/
    ;

    public final native Number spacingRight()
        throws RuntimeException /*-{
        return this["spacingRight"] = (this["spacingRight"] || 10.0);
    }-*/
    ;

    public final native JsoChart spacingRight(Number spacingRight)
        throws RuntimeException /*-{
        this["spacingRight"] = spacingRight;
        return this;
    }-*/
    ;

    public final native Number spacingTop()
        throws RuntimeException /*-{
        return this["spacingTop"] = (this["spacingTop"] || 10.0);
    }-*/
    ;

    public final native JsoChart spacingTop(Number spacingTop)
        throws RuntimeException /*-{
        this["spacingTop"] = spacingTop;
        return this;
    }-*/
    ;

    public final native String type()
        throws RuntimeException /*-{
        return this["type"] = (this["type"] || "line");
    }-*/
    ;

    public final native JsoChart type(String type)
        throws RuntimeException /*-{
        this["type"] = type;
        return this;
    }-*/
    ;

    public final native Number width()
        throws RuntimeException /*-{
        return this["width"] = (this["width"] || null);
    }-*/
    ;

    public final native JsoChart width(Number width)
        throws RuntimeException /*-{
        this["width"] = width;
        return this;
    }-*/
    ;

    public final native String zoomType()
        throws RuntimeException /*-{
        return this["zoomType"] = (this["zoomType"] || "null");
    }-*/
    ;

    public final native JsoChart zoomType(String zoomType)
        throws RuntimeException /*-{
        this["zoomType"] = zoomType;
        return this;
    }-*/
    ;

}
