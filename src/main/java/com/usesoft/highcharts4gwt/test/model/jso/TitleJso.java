package com.usesoft.highcharts4gwt.test.model.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.test.model.api.Title;

/** The JSO implementation of Person. */
public class TitleJso extends JavaScriptObject implements Title
{

    protected TitleJso()
    {
    }

    //
    // public static TitleJso create(){
    // return (TitleJso) JavaScriptObject.createObject();
    // }
    //
    public final native String text()
    /*-{
        return this["text"];
    }-*/;

    public final native Title text(String text)
    /*-{
        this["text"]=text;
        return this;
    }-*/;
}
