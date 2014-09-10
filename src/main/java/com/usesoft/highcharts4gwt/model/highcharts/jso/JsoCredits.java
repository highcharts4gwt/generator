
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Credits;

public class JsoCredits
    extends JavaScriptObject
    implements Credits
{


    protected JsoCredits() {
    }

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || {});
    }-*/
    ;

    public final native JsoCredits enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native String href()
        throws RuntimeException /*-{
        return this["href"] = (this["href"] || {});
    }-*/
    ;

    public final native JsoCredits href(String href)
        throws RuntimeException /*-{
        this["href"] = href;
        return this;
    }-*/
    ;

    public final native String text()
        throws RuntimeException /*-{
        return this["text"] = (this["text"] || {});
    }-*/
    ;

    public final native JsoCredits text(String text)
        throws RuntimeException /*-{
        this["text"] = text;
        return this;
    }-*/
    ;

}
