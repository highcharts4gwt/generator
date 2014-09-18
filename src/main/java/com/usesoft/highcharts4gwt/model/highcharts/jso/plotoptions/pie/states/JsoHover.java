
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.pie.states;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.pie.states.Hover;

public class JsoHover
    extends JavaScriptObject
    implements Hover
{


    protected JsoHover() {
    }

    public final native Number brightness()
        throws RuntimeException /*-{
        return this["brightness"] = (this["brightness"] || 0.1);
    }-*/
    ;

    public final native JsoHover brightness(Number brightness)
        throws RuntimeException /*-{
        this["brightness"] = brightness;
        return this;
    }-*/
    ;

}
