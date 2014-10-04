
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Pie;

public interface Funnel
    extends Pie
{


    boolean reversed();

    Funnel reversed(boolean reversed);

}
