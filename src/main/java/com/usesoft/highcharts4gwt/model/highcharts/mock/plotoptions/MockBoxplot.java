
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Boxplot;
import com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.MockColumn;

public class MockBoxplot
    extends MockColumn
    implements Boxplot
{

    private Number medianWidth;
    private String stemDashStyle;
    private Number stemWidth;
    private Number whiskerWidth;

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
