
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Waterfall;

public class MockWaterfall
    implements Waterfall
{

    private String dashStyle;

    public String dashStyle() {
        return dashStyle;
    }

    public MockWaterfall dashStyle(String dashStyle) {
        this.dashStyle = dashStyle;
        return this;
    }

}
