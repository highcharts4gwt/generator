
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Subtitle;

public class JsoSubtitle
    extends JavaScriptObject
    implements Subtitle
{


    protected JsoSubtitle() {
    }

    public final native String align()
        throws RuntimeException /*-{
        return this["align"] = (this["align"] || {});
    }-*/
    ;

    public final native JsoSubtitle align(String align)
        throws RuntimeException /*-{
        this["align"] = align;
        return this;
    }-*/
    ;

    public final native boolean floating()
        throws RuntimeException /*-{
        return this["floating"] = (this["floating"] || {});
    }-*/
    ;

    public final native JsoSubtitle floating(boolean floating)
        throws RuntimeException /*-{
        this["floating"] = floating;
        return this;
    }-*/
    ;

    public final native String text()
        throws RuntimeException /*-{
        return this["text"] = (this["text"] || {});
    }-*/
    ;

    public final native JsoSubtitle text(String text)
        throws RuntimeException /*-{
        this["text"] = text;
        return this;
    }-*/
    ;

    public final native boolean useHTML()
        throws RuntimeException /*-{
        return this["useHTML"] = (this["useHTML"] || {});
    }-*/
    ;

    public final native JsoSubtitle useHTML(boolean useHTML)
        throws RuntimeException /*-{
        this["useHTML"] = useHTML;
        return this;
    }-*/
    ;

    public final native String verticalAlign()
        throws RuntimeException /*-{
        return this["verticalAlign"] = (this["verticalAlign"] || {});
    }-*/
    ;

    public final native JsoSubtitle verticalAlign(String verticalAlign)
        throws RuntimeException /*-{
        this["verticalAlign"] = verticalAlign;
        return this;
    }-*/
    ;

    public final native Number x()
        throws RuntimeException /*-{
        return this["x"] = (this["x"] || {});
    }-*/
    ;

    public final native JsoSubtitle x(Number x)
        throws RuntimeException /*-{
        this["x"] = x;
        return this;
    }-*/
    ;

    public final native Number y()
        throws RuntimeException /*-{
        return this["y"] = (this["y"] || {});
    }-*/
    ;

    public final native JsoSubtitle y(Number y)
        throws RuntimeException /*-{
        this["y"] = y;
        return this;
    }-*/
    ;

}
