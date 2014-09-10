
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class JsoSeries
    extends JavaScriptObject
    implements Series
{


    protected JsoSeries() {
    }

    public final native ArrayNumber data()
        throws RuntimeException /*-{
        return this["data"] = (this["data"] || {});
    }-*/
    ;

    public final native JsoSeries data(ArrayNumber data)
        throws RuntimeException /*-{
        this["data"] = data;
        return this;
    }-*/
    ;

    public final native String dataURL()
        throws RuntimeException /*-{
        return this["dataURL"] = (this["dataURL"] || {});
    }-*/
    ;

    public final native JsoSeries dataURL(String dataURL)
        throws RuntimeException /*-{
        this["dataURL"] = dataURL;
        return this;
    }-*/
    ;

    public final native String id()
        throws RuntimeException /*-{
        return this["id"] = (this["id"] || {});
    }-*/
    ;

    public final native JsoSeries id(String id)
        throws RuntimeException /*-{
        this["id"] = id;
        return this;
    }-*/
    ;

    public final native Number index()
        throws RuntimeException /*-{
        return this["index"] = (this["index"] || {});
    }-*/
    ;

    public final native JsoSeries index(Number index)
        throws RuntimeException /*-{
        this["index"] = index;
        return this;
    }-*/
    ;

    public final native Number legendIndex()
        throws RuntimeException /*-{
        return this["legendIndex"] = (this["legendIndex"] || {});
    }-*/
    ;

    public final native JsoSeries legendIndex(Number legendIndex)
        throws RuntimeException /*-{
        this["legendIndex"] = legendIndex;
        return this;
    }-*/
    ;

    public final native String name()
        throws RuntimeException /*-{
        return this["name"] = (this["name"] || {});
    }-*/
    ;

    public final native JsoSeries name(String name)
        throws RuntimeException /*-{
        this["name"] = name;
        return this;
    }-*/
    ;

    public final native String type()
        throws RuntimeException /*-{
        return this["type"] = (this["type"] || {});
    }-*/
    ;

    public final native JsoSeries type(String type)
        throws RuntimeException /*-{
        this["type"] = type;
        return this;
    }-*/
    ;

    public final native Number zIndex()
        throws RuntimeException /*-{
        return this["zIndex"] = (this["zIndex"] || {});
    }-*/
    ;

    public final native JsoSeries zIndex(Number zIndex)
        throws RuntimeException /*-{
        this["zIndex"] = zIndex;
        return this;
    }-*/
    ;

}
