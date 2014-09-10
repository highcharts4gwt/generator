
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Navigation;
import com.usesoft.highcharts4gwt.model.highcharts.api.navigation.ButtonOptions;

public class JsoNavigation
    extends JavaScriptObject
    implements Navigation
{


    protected JsoNavigation() {
    }

    public final native ButtonOptions buttonOptions()
        throws RuntimeException /*-{
        return this["buttonOptions"] = (this["buttonOptions"] || {});
    }-*/
    ;

    public final native JsoNavigation buttonOptions(ButtonOptions buttonOptions)
        throws RuntimeException /*-{
        this["buttonOptions"] = buttonOptions;
        return this;
    }-*/
    ;

}
