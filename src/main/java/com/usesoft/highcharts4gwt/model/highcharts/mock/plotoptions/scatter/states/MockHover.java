
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.scatter.states;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.states.Hover;

public class MockHover
    implements Hover
{

    private Number lineWidth;

    public Number lineWidth() {
        return lineWidth;
    }

    public MockHover lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

}
