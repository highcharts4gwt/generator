
package com.usesoft.highcharts4gwt.model.highcharts.mock.chart;

import com.usesoft.highcharts4gwt.model.highcharts.api.chart.Options3d;
import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.Frame;

public class MockOptions3d
    implements Options3d
{

    private Number alpha;
    private Number beta;
    private Number depth;
    private boolean enabled;
    private Frame frame;
    private Number viewDistance;

    public Number alpha() {
        return alpha;
    }

    public MockOptions3d alpha(Number alpha) {
        this.alpha = alpha;
        return this;
    }

    public Number beta() {
        return beta;
    }

    public MockOptions3d beta(Number beta) {
        this.beta = beta;
        return this;
    }

    public Number depth() {
        return depth;
    }

    public MockOptions3d depth(Number depth) {
        this.depth = depth;
        return this;
    }

    public boolean enabled() {
        return enabled;
    }

    public MockOptions3d enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Frame frame() {
        return frame;
    }

    public MockOptions3d frame(Frame frame) {
        this.frame = frame;
        return this;
    }

    public Number viewDistance() {
        return viewDistance;
    }

    public MockOptions3d viewDistance(Number viewDistance) {
        this.viewDistance = viewDistance;
        return this;
    }

}
