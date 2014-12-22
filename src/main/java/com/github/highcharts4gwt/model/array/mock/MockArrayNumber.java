package com.github.highcharts4gwt.model.array.mock;

import java.util.ArrayList;

import com.github.highcharts4gwt.model.array.api.ArrayNumber;

public class MockArrayNumber implements ArrayNumber
{
    private final ArrayList<Double> list = new ArrayList<Double>();

    @Override
    public double get(int arg0)
    {
        return list.get(arg0);
    }

    @Override
    public int length()
    {
        return list.size();
    }

    @Override
    public void setValue(int index, double element)
    {
        list.set(index, element);
    }

    @Override
    public void push(double value)
    {
        list.add(value);
    }

    @Override
    public void setLength(int newLength)
    {
    }

}
