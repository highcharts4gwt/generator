
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.usesoft.highcharts4gwt.model.highcharts.api.YAxis;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.StackLabels;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoXAxis;

public class JsoYAxis
    extends JsoXAxis
    implements YAxis
{


    protected JsoYAxis() {
    }

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

}
