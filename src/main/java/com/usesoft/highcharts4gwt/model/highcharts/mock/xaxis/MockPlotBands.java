
package com.usesoft.highcharts4gwt.model.highcharts.mock.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotBands;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotbands.Label;

public class MockPlotBands
    implements PlotBands
{

    private Number from;
    private String id;
    private Label label;
    private Number to;
    private Number zIndex;

    public Number from() {
        return from;
    }

    public MockPlotBands from(Number from) {
        this.from = from;
        return this;
    }

    public String id() {
        return id;
    }

    public MockPlotBands id(String id) {
        this.id = id;
        return this;
    }

    public Label label() {
        return label;
    }

    public MockPlotBands label(Label label) {
        this.label = label;
        return this;
    }

    public Number to() {
        return to;
    }

    public MockPlotBands to(Number to) {
        this.to = to;
        return this;
    }

    public Number zIndex() {
        return zIndex;
    }

    public MockPlotBands zIndex(Number zIndex) {
        this.zIndex = zIndex;
        return this;
    }

}
