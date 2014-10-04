
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bubble;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.Labels;

public interface DataLabels
    extends Labels
{


    Number borderRadius();

    DataLabels borderRadius(Number borderRadius);

    Number borderWidth();

    DataLabels borderWidth(Number borderWidth);

    boolean crop();

    DataLabels crop(boolean crop);

    boolean defer();

    DataLabels defer(boolean defer);

    boolean inside();

    DataLabels inside(boolean inside);

    Number padding();

    DataLabels padding(Number padding);

    String verticalAlign();

    DataLabels verticalAlign(String verticalAlign);

}
