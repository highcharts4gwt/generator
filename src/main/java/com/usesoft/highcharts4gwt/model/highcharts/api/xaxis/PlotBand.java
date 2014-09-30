
package com.usesoft.highcharts4gwt.model.highcharts.api.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotbands.Label;

public interface PlotBand {


    Number from();

    PlotBand from(Number from);

    String id();

    PlotBand id(String id);

    Label label();

    PlotBand label(Label label);

    Number to();

    PlotBand to(Number to);

    Number zIndex();

    PlotBand zIndex(Number zIndex);

}
