package com.usesoft.highcharts4gwt.test.model.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.test.model.api.Options;
import com.usesoft.highcharts4gwt.test.model.api.Title;

public class OptionsJso extends JavaScriptObject implements Options
{

    protected OptionsJso()
    {
    }

    public final native Options title(Title title)
    /*-{
      this["title"]=title;
      return this;
    }-*/;

    public final native Title title()
    /*-{
      if (typeof this["title"] == 'undefined')
          this["title"] = {};
      return this["title"];
    }-*/;
}
