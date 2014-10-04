
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Line;
import com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.MockSeries;

public class MockLine
    extends MockSeries
    implements Line
{

    private String step;

    public String step() {
        return step;
    }

    public MockLine step(String step) {
        this.step = step;
        return this;
    }

}
