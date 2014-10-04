
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bubble.marker;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bubble.marker.states.Hover;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.bubble.marker.states.Select;

public interface States {


    Hover hover();

    States hover(Hover hover);

    Select select();

    States select(Select select);

}
