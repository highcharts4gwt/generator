
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Bar;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bar.DataLabels;

public class MockBar
    implements Bar
{

    private DataLabels dataLabels;

    public DataLabels dataLabels() {
        return dataLabels;
    }

    public MockBar dataLabels(DataLabels dataLabels) {
        this.dataLabels = dataLabels;
        return this;
    }

}
