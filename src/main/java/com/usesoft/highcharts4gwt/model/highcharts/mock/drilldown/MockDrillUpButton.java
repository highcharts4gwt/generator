
package com.usesoft.highcharts4gwt.model.highcharts.mock.drilldown;

import com.usesoft.highcharts4gwt.model.highcharts.api.drilldown.DrillUpButton;

public class MockDrillUpButton
    implements DrillUpButton
{

    private String relativeTo;

    public String relativeTo() {
        return relativeTo;
    }

    public MockDrillUpButton relativeTo(String relativeTo) {
        this.relativeTo = relativeTo;
        return this;
    }

}
