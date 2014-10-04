
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.funnel;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.funnel.States;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.funnel.states.Hover;

public class MockStates
    implements States
{

    private Hover hover;

    public Hover hover() {
        return hover;
    }

    public MockStates hover(Hover hover) {
        this.hover = hover;
        return this;
    }

}
