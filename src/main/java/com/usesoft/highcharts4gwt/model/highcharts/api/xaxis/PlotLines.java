
package com.usesoft.highcharts4gwt.model.highcharts.api.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotlines.Label;

public interface PlotLines {


    String dashStyle();

    PlotLines dashStyle(String dashStyle);

    String id();

    PlotLines id(String id);

    Label label();

    PlotLines label(Label label);

    Number value();

    PlotLines value(Number value);

    Number width();

    PlotLines width(Number width);

    Number zIndex();

    PlotLines zIndex(Number zIndex);

}
