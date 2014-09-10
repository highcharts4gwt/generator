
package com.usesoft.highcharts4gwt.model.highcharts.api;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Area;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Areaspline;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Bar;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Line;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Pie;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Spline;

public interface PlotOptions {


    Area area();

    PlotOptions area(Area area);

    Areaspline areaspline();

    PlotOptions areaspline(Areaspline areaspline);

    Bar bar();

    PlotOptions bar(Bar bar);

    Line line();

    PlotOptions line(Line line);

    Pie pie();

    PlotOptions pie(Pie pie);

    Series series();

    PlotOptions series(Series series);

    Spline spline();

    PlotOptions spline(Spline spline);

}
