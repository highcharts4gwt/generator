
package com.usesoft.highcharts4gwt.model.highcharts.jso.exporting;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.exporting.Buttons;
import com.usesoft.highcharts4gwt.model.highcharts.api.exporting.buttons.ContextButton;

public class JsoButtons
    extends JavaScriptObject
    implements Buttons
{


    protected JsoButtons() {
    }

    public final native ContextButton contextButton()
        throws RuntimeException /*-{
        return this["contextButton"] = (this["contextButton"] || null);
    }-*/
    ;

    public final native JsoButtons contextButton(ContextButton contextButton)
        throws RuntimeException /*-{
        this["contextButton"] = contextButton;
        return this;
    }-*/
    ;

}
