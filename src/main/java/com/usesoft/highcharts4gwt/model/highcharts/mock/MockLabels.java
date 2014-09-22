
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.Labels;
import com.usesoft.highcharts4gwt.model.highcharts.api.labels.Items;

public class MockLabels
    implements Labels
{

    private Array<Items> items;

    public Array<Items> items() {
        return items;
    }

    public MockLabels items(Array<Items> items) {
        this.items = items;
        return this;
    }

}
