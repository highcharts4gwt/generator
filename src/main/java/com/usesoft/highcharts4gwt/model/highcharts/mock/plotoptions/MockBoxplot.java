
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Boxplot;

public class MockBoxplot
    implements Boxplot
{

    private Number lineWidth;
    private Number medianWidth;
    private String stemDashStyle;
    private Number stemWidth;
    private Number whiskerWidth;

    public Number lineWidth() {
        return lineWidth;
    }

    public MockBoxplot lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public Number medianWidth() {
        return medianWidth;
    }

    public MockBoxplot medianWidth(Number medianWidth) {
        this.medianWidth = medianWidth;
        return this;
    }

    public String stemDashStyle() {
        return stemDashStyle;
    }

    public MockBoxplot stemDashStyle(String stemDashStyle) {
        this.stemDashStyle = stemDashStyle;
        return this;
    }

    public Number stemWidth() {
        return stemWidth;
    }

    public MockBoxplot stemWidth(Number stemWidth) {
        this.stemWidth = stemWidth;
        return this;
    }

    public Number whiskerWidth() {
        return whiskerWidth;
    }

    public MockBoxplot whiskerWidth(Number whiskerWidth) {
        this.whiskerWidth = whiskerWidth;
        return this;
    }

}
