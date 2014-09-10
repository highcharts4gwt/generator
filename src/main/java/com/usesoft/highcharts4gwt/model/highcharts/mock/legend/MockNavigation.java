
package com.usesoft.highcharts4gwt.model.highcharts.mock.legend;

import com.usesoft.highcharts4gwt.model.highcharts.api.legend.Navigation;

public class MockNavigation
    implements Navigation
{

    private Number arrowSize;

    public Number arrowSize() {
        return arrowSize;
    }

    public MockNavigation arrowSize(Number arrowSize) {
        this.arrowSize = arrowSize;
        return this;
    }

}
