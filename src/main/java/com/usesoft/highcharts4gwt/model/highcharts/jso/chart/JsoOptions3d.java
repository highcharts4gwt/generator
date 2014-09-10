
package com.usesoft.highcharts4gwt.model.highcharts.jso.chart;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.Options3d;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.Frame;

public class JsoOptions3d
    extends JavaScriptObject
    implements Options3d
{


    protected JsoOptions3d() {
    }

    public final native Number alpha()
        throws RuntimeException /*-{
        return this["alpha"] = (this["alpha"] || {});
    }-*/
    ;

    public final native JsoOptions3d alpha(Number alpha)
        throws RuntimeException /*-{
        this["alpha"] = alpha;
        return this;
    }-*/
    ;

    public final native Number beta()
        throws RuntimeException /*-{
        return this["beta"] = (this["beta"] || {});
    }-*/
    ;

    public final native JsoOptions3d beta(Number beta)
        throws RuntimeException /*-{
        this["beta"] = beta;
        return this;
    }-*/
    ;

    public final native Number depth()
        throws RuntimeException /*-{
        return this["depth"] = (this["depth"] || {});
    }-*/
    ;

    public final native JsoOptions3d depth(Number depth)
        throws RuntimeException /*-{
        this["depth"] = depth;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || {});
    }-*/
    ;

    public final native JsoOptions3d enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native Frame frame()
        throws RuntimeException /*-{
        return this["frame"] = (this["frame"] || {});
    }-*/
    ;

    public final native JsoOptions3d frame(Frame frame)
        throws RuntimeException /*-{
        this["frame"] = frame;
        return this;
    }-*/
    ;

    public final native Number viewDistance()
        throws RuntimeException /*-{
        return this["viewDistance"] = (this["viewDistance"] || {});
    }-*/
    ;

    public final native JsoOptions3d viewDistance(Number viewDistance)
        throws RuntimeException /*-{
        this["viewDistance"] = viewDistance;
        return this;
    }-*/
    ;

}
