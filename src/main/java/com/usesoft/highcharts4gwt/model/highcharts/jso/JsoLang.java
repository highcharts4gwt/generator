
package com.usesoft.highcharts4gwt.model.highcharts.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.Lang;

public class JsoLang
    extends JavaScriptObject
    implements Lang
{


    protected JsoLang() {
    }

    public final native String contextButtonTitle()
        throws RuntimeException /*-{
        return this["contextButtonTitle"] = (this["contextButtonTitle"] || {});
    }-*/
    ;

    public final native JsoLang contextButtonTitle(String contextButtonTitle)
        throws RuntimeException /*-{
        this["contextButtonTitle"] = contextButtonTitle;
        return this;
    }-*/
    ;

    public final native String decimalPoint()
        throws RuntimeException /*-{
        return this["decimalPoint"] = (this["decimalPoint"] || {});
    }-*/
    ;

    public final native JsoLang decimalPoint(String decimalPoint)
        throws RuntimeException /*-{
        this["decimalPoint"] = decimalPoint;
        return this;
    }-*/
    ;

    public final native String downloadJPEG()
        throws RuntimeException /*-{
        return this["downloadJPEG"] = (this["downloadJPEG"] || {});
    }-*/
    ;

    public final native JsoLang downloadJPEG(String downloadJPEG)
        throws RuntimeException /*-{
        this["downloadJPEG"] = downloadJPEG;
        return this;
    }-*/
    ;

    public final native String downloadPDF()
        throws RuntimeException /*-{
        return this["downloadPDF"] = (this["downloadPDF"] || {});
    }-*/
    ;

    public final native JsoLang downloadPDF(String downloadPDF)
        throws RuntimeException /*-{
        this["downloadPDF"] = downloadPDF;
        return this;
    }-*/
    ;

    public final native String downloadPNG()
        throws RuntimeException /*-{
        return this["downloadPNG"] = (this["downloadPNG"] || {});
    }-*/
    ;

    public final native JsoLang downloadPNG(String downloadPNG)
        throws RuntimeException /*-{
        this["downloadPNG"] = downloadPNG;
        return this;
    }-*/
    ;

    public final native String downloadSVG()
        throws RuntimeException /*-{
        return this["downloadSVG"] = (this["downloadSVG"] || {});
    }-*/
    ;

    public final native JsoLang downloadSVG(String downloadSVG)
        throws RuntimeException /*-{
        this["downloadSVG"] = downloadSVG;
        return this;
    }-*/
    ;

    public final native String drillUpText()
        throws RuntimeException /*-{
        return this["drillUpText"] = (this["drillUpText"] || {});
    }-*/
    ;

    public final native JsoLang drillUpText(String drillUpText)
        throws RuntimeException /*-{
        this["drillUpText"] = drillUpText;
        return this;
    }-*/
    ;

    public final native String loading()
        throws RuntimeException /*-{
        return this["loading"] = (this["loading"] || {});
    }-*/
    ;

    public final native JsoLang loading(String loading)
        throws RuntimeException /*-{
        this["loading"] = loading;
        return this;
    }-*/
    ;

    public final native ArrayString months()
        throws RuntimeException /*-{
        return this["months"] = (this["months"] || []);
    }-*/
    ;

    public final native JsoLang months(ArrayString months)
        throws RuntimeException /*-{
        this["months"] = months;
        return this;
    }-*/
    ;

    public final native String noData()
        throws RuntimeException /*-{
        return this["noData"] = (this["noData"] || {});
    }-*/
    ;

    public final native JsoLang noData(String noData)
        throws RuntimeException /*-{
        this["noData"] = noData;
        return this;
    }-*/
    ;

    public final native ArrayString numericSymbols()
        throws RuntimeException /*-{
        return this["numericSymbols"] = (this["numericSymbols"] || []);
    }-*/
    ;

    public final native JsoLang numericSymbols(ArrayString numericSymbols)
        throws RuntimeException /*-{
        this["numericSymbols"] = numericSymbols;
        return this;
    }-*/
    ;

    public final native String printChart()
        throws RuntimeException /*-{
        return this["printChart"] = (this["printChart"] || {});
    }-*/
    ;

    public final native JsoLang printChart(String printChart)
        throws RuntimeException /*-{
        this["printChart"] = printChart;
        return this;
    }-*/
    ;

    public final native String resetZoom()
        throws RuntimeException /*-{
        return this["resetZoom"] = (this["resetZoom"] || {});
    }-*/
    ;

    public final native JsoLang resetZoom(String resetZoom)
        throws RuntimeException /*-{
        this["resetZoom"] = resetZoom;
        return this;
    }-*/
    ;

    public final native String resetZoomTitle()
        throws RuntimeException /*-{
        return this["resetZoomTitle"] = (this["resetZoomTitle"] || {});
    }-*/
    ;

    public final native JsoLang resetZoomTitle(String resetZoomTitle)
        throws RuntimeException /*-{
        this["resetZoomTitle"] = resetZoomTitle;
        return this;
    }-*/
    ;

    public final native ArrayString shortMonths()
        throws RuntimeException /*-{
        return this["shortMonths"] = (this["shortMonths"] || []);
    }-*/
    ;

    public final native JsoLang shortMonths(ArrayString shortMonths)
        throws RuntimeException /*-{
        this["shortMonths"] = shortMonths;
        return this;
    }-*/
    ;

    public final native String thousandsSep()
        throws RuntimeException /*-{
        return this["thousandsSep"] = (this["thousandsSep"] || {});
    }-*/
    ;

    public final native JsoLang thousandsSep(String thousandsSep)
        throws RuntimeException /*-{
        this["thousandsSep"] = thousandsSep;
        return this;
    }-*/
    ;

    public final native ArrayString weekdays()
        throws RuntimeException /*-{
        return this["weekdays"] = (this["weekdays"] || []);
    }-*/
    ;

    public final native JsoLang weekdays(ArrayString weekdays)
        throws RuntimeException /*-{
        this["weekdays"] = weekdays;
        return this;
    }-*/
    ;

}
