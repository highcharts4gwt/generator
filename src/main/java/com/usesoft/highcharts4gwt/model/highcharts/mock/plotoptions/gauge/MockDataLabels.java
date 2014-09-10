
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.gauge;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.gauge.DataLabels;

public class MockDataLabels
    implements DataLabels
{

    private Number borderRadius;
    private Number borderWidth;
    private boolean enabled;
    private String verticalAlign;
    private Number y;
    private Number zIndex;

    public Number borderRadius() {
        return borderRadius;
    }

    public MockDataLabels borderRadius(Number borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public Number borderWidth() {
        return borderWidth;
    }

    public MockDataLabels borderWidth(Number borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public boolean enabled() {
        return enabled;
    }

    public MockDataLabels enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String verticalAlign() {
        return verticalAlign;
    }

    public MockDataLabels verticalAlign(String verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    public Number y() {
        return y;
    }

    public MockDataLabels y(Number y) {
        this.y = y;
        return this;
    }

    public Number zIndex() {
        return zIndex;
    }

    public MockDataLabels zIndex(Number zIndex) {
        this.zIndex = zIndex;
        return this;
    }

}
