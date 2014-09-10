
package com.usesoft.highcharts4gwt.model.highcharts.jso.legend;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.legend.Title;

public class JsoTitle
    extends JavaScriptObject
    implements Title
{


    protected JsoTitle() {
    }

    public final native String text()
        throws RuntimeException /*-{
        return this["text"] = (this["text"] || {});
    }-*/
    ;

    public final native JsoTitle text(String text)
        throws RuntimeException /*-{
        this["text"] = text;
        return this;
    }-*/
    ;

}
