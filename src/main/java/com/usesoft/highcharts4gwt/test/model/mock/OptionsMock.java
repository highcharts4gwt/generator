package com.usesoft.highcharts4gwt.test.model.mock;

import com.usesoft.highcharts4gwt.test.model.api.Options;
import com.usesoft.highcharts4gwt.test.model.api.Title;

public class OptionsMock implements Options
{

    private Title title;

    public OptionsMock()
    {
    }

    public Title title()
    {
        return title;
    }

    public Options title(Title title)
    {
        this.title = title;
        return this;
    }

}
