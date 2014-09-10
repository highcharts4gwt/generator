
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.column.states;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.column.states.Hover;

public class MockHover
    implements Hover
{

    private Number brightness;

    public Number brightness() {
        return brightness;
    }

    public MockHover brightness(Number brightness) {
        this.brightness = brightness;
        return this;
    }

}
