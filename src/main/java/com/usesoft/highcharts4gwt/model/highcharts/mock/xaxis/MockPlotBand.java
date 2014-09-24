
package com.usesoft.highcharts4gwt.model.highcharts.mock.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotBands;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotbands.Label;

public class MockPlotBand
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

    public MockPlotBand from(Number from) {
        this.from = from;
        return this;
    }

    public String id() {
        return id;
    }

    public MockPlotBand id(String id) {
        this.id = id;
        return this;
    }

    public Label label() {
        return label;
    }

    public MockPlotBand label(Label label) {
        this.label = label;
        return this;
    }

    public Number to() {
        return to;
    }

    public MockPlotBand to(Number to) {
        this.to = to;
        return this;
    }

    public Number zIndex() {
        return zIndex;
    }

    public MockPlotBand zIndex(Number zIndex) {
        this.zIndex = zIndex;
        return this;
    }

}
