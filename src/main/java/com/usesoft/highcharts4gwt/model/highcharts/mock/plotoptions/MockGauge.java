
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Gauge;

public class MockGauge
    implements Gauge
{

    private Number overshoot;
    private boolean showInLegend;
    private boolean wrap;

    public Number overshoot() {
        return overshoot;
    }

    public MockGauge overshoot(Number overshoot) {
        this.overshoot = overshoot;
        return this;
    }

    public boolean showInLegend() {
        return showInLegend;
    }

    public MockGauge showInLegend(boolean showInLegend) {
        this.showInLegend = showInLegend;
        return this;
    }

    public boolean wrap() {
        return wrap;
    }

    public MockGauge wrap(boolean wrap) {
        this.wrap = wrap;
        return this;
    }

}
