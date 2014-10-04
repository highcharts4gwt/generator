
package com.usesoft.highcharts4gwt.model.highcharts.mock.series.data.marker;

import com.usesoft.highcharts4gwt.model.highcharts.api.series.data.marker.States;
import com.usesoft.highcharts4gwt.model.highcharts.api.series.data.marker.states.Hover;
import com.usesoft.highcharts4gwt.model.highcharts.api.series.data.marker.states.Select;

public class MockStates
    implements States
{

    private Hover hover;
    private Select select;

    public Hover hover() {
        return hover;
    }

    public MockStates hover(Hover hover) {
        this.hover = hover;
        return this;
    }

    public Select select() {
        return select;
    }

    public MockStates select(Select select) {
        this.select = select;
        return this;
    }

}
