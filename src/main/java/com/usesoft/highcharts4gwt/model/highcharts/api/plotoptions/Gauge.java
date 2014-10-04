
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;

public interface Gauge
    extends Series
{


    Number overshoot();

    Gauge overshoot(Number overshoot);

    boolean wrap();

    Gauge wrap(boolean wrap);

}
