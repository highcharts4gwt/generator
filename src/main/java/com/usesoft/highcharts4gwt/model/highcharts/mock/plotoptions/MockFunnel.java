
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Funnel;
import com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.MockPie;

public class MockFunnel
    extends MockPie
    implements Funnel
{

    private boolean reversed;

    public boolean reversed() {
        return reversed;
    }

    public MockFunnel reversed(boolean reversed) {
        this.reversed = reversed;
        return this;
    }

}
