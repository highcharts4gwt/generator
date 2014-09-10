
package com.usesoft.highcharts4gwt.model.highcharts.api;

import com.usesoft.highcharts4gwt.model.array.api.ArrayString;

public interface Lang {


    String contextButtonTitle();

    Lang contextButtonTitle(String contextButtonTitle);

    String decimalPoint();

    Lang decimalPoint(String decimalPoint);

    String downloadJPEG();

    Lang downloadJPEG(String downloadJPEG);

    String downloadPDF();

    Lang downloadPDF(String downloadPDF);

    String downloadPNG();

    Lang downloadPNG(String downloadPNG);

    String downloadSVG();

    Lang downloadSVG(String downloadSVG);

    String drillUpText();

    Lang drillUpText(String drillUpText);

    String loading();

    Lang loading(String loading);

    ArrayString months();

    Lang months(ArrayString months);

    String noData();

    Lang noData(String noData);

    ArrayString numericSymbols();

    Lang numericSymbols(ArrayString numericSymbols);

    String printChart();

    Lang printChart(String printChart);

    String resetZoom();

    Lang resetZoom(String resetZoom);

    String resetZoomTitle();

    Lang resetZoomTitle(String resetZoomTitle);

    ArrayString shortMonths();

    Lang shortMonths(ArrayString shortMonths);

    String thousandsSep();

    Lang thousandsSep(String thousandsSep);

    ArrayString weekdays();

    Lang weekdays(ArrayString weekdays);

}
