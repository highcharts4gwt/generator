
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.pie;


public interface DataLabels
    extends com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.series.DataLabels
{


    String connectorColor();

    DataLabels connectorColor(String connectorColor);

    Number connectorPadding();

    DataLabels connectorPadding(Number connectorPadding);

    Number connectorWidth();

    DataLabels connectorWidth(Number connectorWidth);

    boolean softConnector();

    DataLabels softConnector(boolean softConnector);

}
