package com.usesoft.highcharts4gwt.test.model.mock;

import com.usesoft.highcharts4gwt.test.model.api.Options;
import com.usesoft.highcharts4gwt.test.model.api.OptionsFactory;

public class OptionsFactoryMock implements OptionsFactory
{

    public Options create()
    {
        return new OptionsMock();
    }

}
