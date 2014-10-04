
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;

public interface Area
    extends Series
{


    Number fillOpacity();

    Area fillOpacity(Number fillOpacity);

    boolean trackByArea();

    Area trackByArea(boolean trackByArea);

}
