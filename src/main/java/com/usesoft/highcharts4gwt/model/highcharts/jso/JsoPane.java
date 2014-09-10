
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Pane;

public class JsoPane
    extends JavaScriptObject
    implements Pane
{


    protected JsoPane() {
    }

    public final native Number endAngle()
        throws RuntimeException /*-{
        return this["endAngle"] = (this["endAngle"] || {});
    }-*/
    ;

    public final native JsoPane endAngle(Number endAngle)
        throws RuntimeException /*-{
        this["endAngle"] = endAngle;
        return this;
    }-*/
    ;

    public final native Number startAngle()
        throws RuntimeException /*-{
        return this["startAngle"] = (this["startAngle"] || {});
    }-*/
    ;

    public final native JsoPane startAngle(Number startAngle)
        throws RuntimeException /*-{
        this["startAngle"] = startAngle;
        return this;
    }-*/
    ;

}
