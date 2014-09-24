
package com.usesoft.highcharts4gwt.model.highcharts.jso.labels;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.labels.Items;

public class JsoItem
    extends JavaScriptObject
    implements Items
{


    protected JsoItem() {
    }

    public final native String html()
        throws RuntimeException /*-{
        return this["html"] = (this["html"] || "null");
    }-*/
    ;

    public final native JsoItem html(String html)
        throws RuntimeException /*-{
        this["html"] = html;
        return this;
    }-*/
    ;

}
