
package com.usesoft.highcharts4gwt.model.highcharts.jso.exporting.buttons;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.exporting.buttons.ContextButton;

public class JsoContextButton
    extends JavaScriptObject
    implements ContextButton
{


    protected JsoContextButton() {
    }

    public final native String symbol()
        throws RuntimeException /*-{
        return this["symbol"] = (this["symbol"] || "menu");
    }-*/
    ;

    public final native JsoContextButton symbol(String symbol)
        throws RuntimeException /*-{
        this["symbol"] = symbol;
        return this;
    }-*/
    ;

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || -10.0);
    }-*/
    ;

    public final native JsoContextButton x(Number x)
        throws RuntimeException /*-{
        this["x"] = x;
        return this;
    }-*/
    ;

}
