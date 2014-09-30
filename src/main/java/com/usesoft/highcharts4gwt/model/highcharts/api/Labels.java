
package com.usesoft.highcharts4gwt.model.highcharts.api;

import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.labels.Item;

public interface Labels {


    Array<Item> items();

    Labels items(Array<Item> items);

}
