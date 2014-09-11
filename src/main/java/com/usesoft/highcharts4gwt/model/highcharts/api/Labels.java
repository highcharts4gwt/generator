
package com.usesoft.highcharts4gwt.model.highcharts.api;

import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.highcharts.api.labels.Items;

public interface Labels {


    Array<Items> items();

    Labels items(Array<Items> items);

}
