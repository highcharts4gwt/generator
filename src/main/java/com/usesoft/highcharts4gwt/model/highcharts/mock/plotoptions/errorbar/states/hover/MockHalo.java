
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.errorbar.states.hover;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.errorbar.states.hover.Halo;

public class MockHalo
    implements Halo
{

    private Number opacity;
    private Number size;

    public Number opacity() {
        return opacity;
    }

    public MockHalo opacity(Number opacity) {
        this.opacity = opacity;
        return this;
    }

    public Number size() {
        return size;
    }

    public MockHalo size(Number size) {
        this.size = size;
        return this;
    }

}
