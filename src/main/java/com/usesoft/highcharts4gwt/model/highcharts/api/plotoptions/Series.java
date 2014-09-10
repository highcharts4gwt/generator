
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.DataLabels;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.Events;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.Marker;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.Point;

public interface Series {


    boolean allowPointSelect();

    Series allowPointSelect(boolean allowPointSelect);

    boolean animation();

    Series animation(boolean animation);

    boolean connectEnds();

    Series connectEnds(boolean connectEnds);

    boolean connectNulls();

    Series connectNulls(boolean connectNulls);

    Number cropThreshold();

    Series cropThreshold(Number cropThreshold);

    String cursor();

    Series cursor(String cursor);

    String dashStyle();

    Series dashStyle(String dashStyle);

    DataLabels dataLabels();

    Series dataLabels(DataLabels dataLabels);

    boolean enableMouseTracking();

    Series enableMouseTracking(boolean enableMouseTracking);

    Events events();

    Series events(Events events);

    Number lineWidth();

    Series lineWidth(Number lineWidth);

    String linkedTo();

    Series linkedTo(String linkedTo);

    Marker marker();

    Series marker(Marker marker);

    Point point();

    Series point(Point point);

    Number pointInterval();

    Series pointInterval(Number pointInterval);

    String pointPlacement();

    Series pointPlacement(String pointPlacement);

    Number pointStart();

    Series pointStart(Number pointStart);

    boolean selected();

    Series selected(boolean selected);

    boolean showCheckbox();

    Series showCheckbox(boolean showCheckbox);

    boolean showInLegend();

    Series showInLegend(boolean showInLegend);

    String stacking();

    Series stacking(String stacking);

    boolean stickyTracking();

    Series stickyTracking(boolean stickyTracking);

    Number threshold();

    Series threshold(Number threshold);

    Number turboThreshold();

    Series turboThreshold(Number turboThreshold);

    boolean visible();

    Series visible(boolean visible);

}
