package com.usesoft.highcharts4gwt.model.mock;

import com.usesoft.highcharts4gwt.model.api.Options;
import com.usesoft.highcharts4gwt.model.api.OptionsFactory;

public class OptionsFactoryMock implements OptionsFactory
{

    public Options create()
    {
        return new OptionsMock();
    }

}
