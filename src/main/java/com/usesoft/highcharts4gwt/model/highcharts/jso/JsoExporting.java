
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.highcharts.api.Exporting;
import com.usesoft.highcharts4gwt.model.highcharts.api.exporting.Buttons;

public class JsoExporting
    extends JavaScriptObject
    implements Exporting
{


    protected JsoExporting() {
    }

    public final native Buttons buttons()
        throws RuntimeException /*-{
        return this["buttons"] = (this["buttons"] || {});
    }-*/
    ;

    public final native JsoExporting buttons(Buttons buttons)
        throws RuntimeException /*-{
        this["buttons"] = buttons;
        return this;
    }-*/
    ;

    public final native boolean enabled()
        throws RuntimeException /*-{
        return this["enabled"] = (this["enabled"] || {});
    }-*/
    ;

    public final native JsoExporting enabled(boolean enabled)
        throws RuntimeException /*-{
        this["enabled"] = enabled;
        return this;
    }-*/
    ;

    public final native String filename()
        throws RuntimeException /*-{
        return this["filename"] = (this["filename"] || {});
    }-*/
    ;

    public final native JsoExporting filename(String filename)
        throws RuntimeException /*-{
        this["filename"] = filename;
        return this;
    }-*/
    ;

    public final native Number scale()
        throws RuntimeException /*-{
        return this["scale"] = (this["scale"] || {});
    }-*/
    ;

    public final native JsoExporting scale(Number scale)
        throws RuntimeException /*-{
        this["scale"] = scale;
        return this;
    }-*/
    ;

    public final native Number sourceHeight()
        throws RuntimeException /*-{
        return this["sourceHeight"] = (this["sourceHeight"] || {});
    }-*/
    ;

    public final native JsoExporting sourceHeight(Number sourceHeight)
        throws RuntimeException /*-{
        this["sourceHeight"] = sourceHeight;
        return this;
    }-*/
    ;

    public final native Number sourceWidth()
        throws RuntimeException /*-{
        return this["sourceWidth"] = (this["sourceWidth"] || {});
    }-*/
    ;

    public final native JsoExporting sourceWidth(Number sourceWidth)
        throws RuntimeException /*-{
        this["sourceWidth"] = sourceWidth;
        return this;
    }-*/
    ;

    public final native String type()
        throws RuntimeException /*-{
        return this["type"] = (this["type"] || {});
    }-*/
    ;

    public final native JsoExporting type(String type)
        throws RuntimeException /*-{
        this["type"] = type;
        return this;
    }-*/
    ;

    public final native String url()
        throws RuntimeException /*-{
        return this["url"] = (this["url"] || {});
    }-*/
    ;

    public final native JsoExporting url(String url)
        throws RuntimeException /*-{
        this["url"] = url;
        return this;
    }-*/
    ;

    public final native Number width()
        throws RuntimeException /*-{
        return this["width"] = (this["width"] || {});
    }-*/
    ;

    public final native JsoExporting width(Number width)
        throws RuntimeException /*-{
        this["width"] = width;
        return this;
    }-*/
    ;

}
