
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.Labels;

public class MockLabels
    implements Labels
{

    private Array<MockLabels> items;

    public Array<MockLabels> items() {
        return items;
    }

    public MockLabels items(Array<MockLabels> items) {
        this.items = items;
        return this;
    }

}
