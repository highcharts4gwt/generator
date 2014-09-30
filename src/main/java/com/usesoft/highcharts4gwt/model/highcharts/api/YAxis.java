
package com.usesoft.highcharts4gwt.model.highcharts.api;

import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Events;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Labels;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.PlotBand;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.PlotLine;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.StackLabels;
import com.usesoft.highcharts4gwt.model.highcharts.api.yaxis.Title;

public interface YAxis {


    boolean endOnTick();

    YAxis endOnTick(boolean endOnTick);

    Events events();

    YAxis events(Events events);

    String gridLineInterpolation();

    YAxis gridLineInterpolation(String gridLineInterpolation);

    Number gridLineWidth();

    YAxis gridLineWidth(Number gridLineWidth);

    Labels labels();

    YAxis labels(Labels labels);

    Number lineWidth();

    YAxis lineWidth(Number lineWidth);

    Number maxPadding();

    YAxis maxPadding(Number maxPadding);

    Number minPadding();

    YAxis minPadding(Number minPadding);

    Array<PlotBand> plotBands();

    YAxis plotBands(Array<PlotBand> plotBands);

    Array<PlotLine> plotLines();

    YAxis plotLines(Array<PlotLine> plotLines);

    boolean reversedStacks();

    YAxis reversedStacks(boolean reversedStacks);

    boolean showLastLabel();

    YAxis showLastLabel(boolean showLastLabel);

    StackLabels stackLabels();

    YAxis stackLabels(StackLabels stackLabels);

    boolean startOnTick();

    YAxis startOnTick(boolean startOnTick);

    Number tickWidth();

    YAxis tickWidth(Number tickWidth);

    Title title();

    YAxis title(Title title);

}
