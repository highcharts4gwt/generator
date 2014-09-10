
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.pie;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.pie.DataLabels;

public class MockDataLabels
    implements DataLabels
{

    private String align;
    private String connectorColor;
    private Number connectorPadding;
    private Number connectorWidth;
    private Number distance;
    private boolean enabled;
    private boolean softConnector;

    public String align() {
        return align;
    }

    public MockDataLabels align(String align) {
        this.align = align;
        return this;
    }

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

    public Number distance() {
        return distance;
    }

    public MockDataLabels distance(Number distance) {
        this.distance = distance;
        return this;
    }

    public boolean enabled() {
        return enabled;
    }

    public MockDataLabels enabled(boolean enabled) {
        this.enabled = enabled;
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
