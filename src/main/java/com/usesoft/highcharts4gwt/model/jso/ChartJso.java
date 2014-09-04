package com.usesoft.highcharts4gwt.model.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.api.Chart;
import com.usesoft.highcharts4gwt.model.api.Options;

public class ChartJso extends JavaScriptObject implements Chart
{

    public final native Options options()/*-
                                         {
                                         return this["options"] = (this["options"] || {});
                                         }-*/;

}
