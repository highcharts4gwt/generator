package com.usesoft.highcharts4gwt.model.dynamic.highcharts.mock;

import com.usesoft.highcharts4gwt.model.dynamic.highcharts.api.Point;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class MockPoint implements Point
{
    private Double y;
    private Double x;
    private Double total;
    private Series series;
    private Double percentage;
    private Double categoryAsDouble;
    private String categoryAsString;

    @Override
    public String categoryAsString()
    {
        return categoryAsString;
    }

    @Override
    public Double categoryAsDouble()
    {
        return categoryAsDouble;
    }

    @Override
    public Double percentage()
    {
        return percentage;
    }

    @Override
    public Series series()
    {
        return series;
    }

    @Override
    public Double total()
    {
        return total;
    }

    @Override
    public Double x()
    {
        return x;
    }

    @Override
    public Double y()
    {
        return y;
    }

    public void setY(Double y)
    {
        this.y = y;
    }

    public void setX(Double x)
    {
        this.x = x;
    }

    public void setTotal(Double total)
    {
        this.total = total;
    }

    public void setSeries(Series series)
    {
        this.series = series;
    }

    public void setPercentage(Double percentage)
    {
        this.percentage = percentage;
    }

    public void setCategoryAsDouble(Double categoryAsDouble)
    {
        this.categoryAsDouble = categoryAsDouble;
    }

    public void setCategoryAsString(String categoryAsString)
    {
        this.categoryAsString = categoryAsString;
    }

}
