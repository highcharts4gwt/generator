package com.github.highcharts4gwt.model.array.mock;

import java.util.ArrayList;

import com.github.highcharts4gwt.model.array.api.ArrayString;

public class MockArrayString extends ArrayList<String> implements ArrayString
{
    private static final long serialVersionUID = 1L;

    @Override
    public int length()
    {
        return size();
    }

    @Override
    public void setValue(int index, String element)
    {
        super.set(index, element);
    }

    @Override
    public void push(String value)
    {
        add(value);
    }

    @Override
    public void setLength(int newLength)
    {
    }

}
