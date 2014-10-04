
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.line;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.line.Point;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.line.point.Events;

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
