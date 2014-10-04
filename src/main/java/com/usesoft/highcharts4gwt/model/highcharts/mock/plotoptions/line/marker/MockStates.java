
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.line.marker;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.line.marker.States;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.line.marker.states.Hover;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.line.marker.states.Select;

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
