
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.pie;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.pie.DataLabels;

public class MockDataLabels
    extends com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.series.MockDataLabels
    implements DataLabels
{

    private String connectorColor;
    private Number connectorPadding;
    private Number connectorWidth;
    private boolean softConnector;

    public String connectorColor() {
        return connectorColor;
    }

    public MockDataLabels connectorColor(String connectorColor) {
        this.connectorColor = connectorColor;
        return this;
    }

    public Number connectorPadding() {
        return connectorPadding;
    }

    public MockDataLabels connectorPadding(Number connectorPadding) {
        this.connectorPadding = connectorPadding;
        return this;
    }

    public Number connectorWidth() {
        return connectorWidth;
    }

    public MockDataLabels connectorWidth(Number connectorWidth) {
        this.connectorWidth = connectorWidth;
        return this;
    }

    public boolean softConnector() {
        return softConnector;
    }

    public MockDataLabels softConnector(boolean softConnector) {
        this.softConnector = softConnector;
        return this;
    }

}
