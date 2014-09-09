package com.usesoft.highcharts4gwt.test.model.mock;

import com.usesoft.highcharts4gwt.test.model.api.Chart;
import com.usesoft.highcharts4gwt.test.model.api.Options;

public class ChartMock implements Chart
{

    private Options options;

    public Options options()
    {
        return this.options;
    }

}
