
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Global;

public class JsoGlobal
    extends JavaScriptObject
    implements Global
{


    protected JsoGlobal() {
    }

    public final native String VMLRadialGradientURL()
        throws RuntimeException /*-{
        return this["VMLRadialGradientURL"] = (this["VMLRadialGradientURL"] || {});
    }-*/
    ;

    public final native JsoGlobal VMLRadialGradientURL(String VMLRadialGradientURL)
        throws RuntimeException /*-{
        this["VMLRadialGradientURL"] = VMLRadialGradientURL;
        return this;
    }-*/
    ;

    public final native String canvasToolsURL()
        throws RuntimeException /*-{
        return this["canvasToolsURL"] = (this["canvasToolsURL"] || {});
    }-*/
    ;

    public final native JsoGlobal canvasToolsURL(String canvasToolsURL)
        throws RuntimeException /*-{
        this["canvasToolsURL"] = canvasToolsURL;
        return this;
    }-*/
    ;

    public final native Number timezoneOffset()
        throws RuntimeException /*-{
        return this["timezoneOffset"] = (this["timezoneOffset"] || {});
    }-*/
    ;

    public final native JsoGlobal timezoneOffset(Number timezoneOffset)
        throws RuntimeException /*-{
        this["timezoneOffset"] = timezoneOffset;
        return this;
    }-*/
    ;

    public final native boolean useUTC()
        throws RuntimeException /*-{
        return this["useUTC"] = (this["useUTC"] || {});
    }-*/
    ;

    public final native JsoGlobal useUTC(boolean useUTC)
        throws RuntimeException /*-{
        this["useUTC"] = useUTC;
        return this;
    }-*/
    ;

}
