
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Pyramid;

public class MockPyramid
    implements Pyramid
{

    private boolean reversed;

    public boolean reversed() {
        return reversed;
    }

    public MockPyramid reversed(boolean reversed) {
        this.reversed = reversed;
        return this;
    }

}
