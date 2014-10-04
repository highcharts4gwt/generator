
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.scatter;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.Point;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.point.Events;

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
