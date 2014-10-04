
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.waterfall;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.waterfall.Point;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.waterfall.point.Events;

public class MockPoint
    implements Point
{

    private Events events;

    public Events events() {
        return events;
    }

    public MockPoint events(Events events) {
        this.events = events;
        return this;
    }

}
