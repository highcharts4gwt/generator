
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Loading;

public class JsoLoading
    extends JavaScriptObject
    implements Loading
{


    protected JsoLoading() {
    }

    public final native Number hideDuration()
        throws RuntimeException /*-{
        return this["hideDuration"] = (this["hideDuration"] || 100.0);
    }-*/
    ;

    public final native JsoLoading hideDuration(Number hideDuration)
        throws RuntimeException /*-{
        this["hideDuration"] = hideDuration;
        return this;
    }-*/
    ;

    public final native Number showDuration()
        throws RuntimeException /*-{
        return this["showDuration"] = (this["showDuration"] || 100.0);
    }-*/
    ;

    public final native JsoLoading showDuration(Number showDuration)
        throws RuntimeException /*-{
        this["showDuration"] = showDuration;
        return this;
    }-*/
    ;

}
