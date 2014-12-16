package com.usesoft.highcharts4gwt.model.dynamic.highcharts.api;

import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public interface Point
{
    String categoryAsString();

    Double categoryAsDouble();

    Double percentage();

    Series series();

    Double total();

    Double x();

    Double y();
}
