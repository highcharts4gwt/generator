
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.area.states.hover;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.area.states.hover.Halo;

public class JsoHalo
    extends JavaScriptObject
    implements Halo
{


    protected JsoHalo() {
    }

    public final native Number opacity()
        throws RuntimeException /*-{
        return this["opacity"] = (this["opacity"] || 0.25);
    }-*/
    ;

    public final native JsoHalo opacity(Number opacity)
        throws RuntimeException /*-{
        this["opacity"] = opacity;
        return this;
    }-*/
    ;

    public final native Number size()
        throws RuntimeException /*-{
        return this["size"] = (this["size"] || 10.0);
    }-*/
    ;

    public final native JsoHalo size(Number size)
        throws RuntimeException /*-{
        this["size"] = size;
        return this;
    }-*/
    ;

}
