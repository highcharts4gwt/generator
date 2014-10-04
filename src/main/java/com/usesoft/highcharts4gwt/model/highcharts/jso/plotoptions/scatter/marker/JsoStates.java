
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.scatter.marker;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.marker.States;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.marker.states.Hover;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.marker.states.Select;

public class JsoStates
    extends JavaScriptObject
    implements States
{


    protected JsoStates() {
    }

    public final native Hover hover()
        throws RuntimeException /*-{
        return this["hover"] = (this["hover"] || {});
    }-*/
    ;

    public final native JsoStates hover(Hover hover)
        throws RuntimeException /*-{
        this["hover"] = hover;
        return this;
    }-*/
    ;

    public final native Select select()
        throws RuntimeException /*-{
        return this["select"] = (this["select"] || {});
    }-*/
    ;

    public final native JsoStates select(Select select)
        throws RuntimeException /*-{
        this["select"] = select;
        return this;
    }-*/
    ;

}
