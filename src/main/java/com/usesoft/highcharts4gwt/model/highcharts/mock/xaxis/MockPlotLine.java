
package com.usesoft.highcharts4gwt.model.highcharts.mock.xaxis;

import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotLine;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.plotlines.Label;

public class MockPlotLine
    implements PlotLine
{

    private String dashStyle;
    private String id;
    private Label label;
    private Number value;
    private Number width;
    private Number zIndex;

    public String dashStyle() {
        return dashStyle;
    }

    public MockPlotLine dashStyle(String dashStyle) {
        this.dashStyle = dashStyle;
        return this;
    }

    public String id() {
        return id;
    }

    public MockPlotLine id(String id) {
        this.id = id;
        return this;
    }

    public Label label() {
        return label;
    }

    public MockPlotLine label(Label label) {
        this.label = label;
        return this;
    }

    public Number value() {
        return value;
    }

    public MockPlotLine value(Number value) {
        this.value = value;
        return this;
    }

    public Number width() {
        return width;
    }

    public MockPlotLine width(Number width) {
        this.width = width;
        return this;
    }

    public Number zIndex() {
        return zIndex;
    }

    public MockPlotLine zIndex(Number zIndex) {
        this.zIndex = zIndex;
        return this;
    }

}
