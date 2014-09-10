
package com.usesoft.highcharts4gwt.model.highcharts.api.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotbands.Label;

public interface PlotBands {


    Number from();

    PlotBands from(Number from);

    String id();

    PlotBands id(String id);

    Label label();

    PlotBands label(Label label);

    Number to();

    PlotBands to(Number to);

    Number zIndex();

    PlotBands zIndex(Number zIndex);

}
