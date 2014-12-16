package com.usesoft.highcharts4gwt.model.dynamic.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.dynamic.highcharts.api.Point;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class JsoPoint extends JavaScriptObject implements Point
{
    protected JsoPoint()
    {
    }

    @Override
    public final native String categoryAsString()/*-{
        return this["category"];
    }-*/
    ;

    @Override
    public final native Double categoryAsDouble()/*-{
        return this["category"];
    }-*/
    ;

    @Override
    public final native Double percentage()/*-{
        return this["percentage"];
    }-*/
    ;

    @Override
    public final native Series series()/*-{
        return this["series"];
    }-*/
    ;

    @Override
    public final native Double total()/*-{
        return this["total"];
    }-*/
    ;

    @Override
    public final native Double x()/*-{
        return this["x"];
    }-*/
    ;

    @Override
    public final native Double y()/*-{
        return this["y"];
    }-*/
    ;

}
