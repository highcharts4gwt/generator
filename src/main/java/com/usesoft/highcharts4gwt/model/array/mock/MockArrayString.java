package com.usesoft.highcharts4gwt.model.array.mock;

import java.util.ArrayList;

import com.usesoft.highcharts4gwt.model.array.api.ArrayString;

public class MockArrayString extends ArrayList<String> implements ArrayString
{
    private static final long serialVersionUID = 1L;

    @Override
    public int length()
    {
        return size();
    }

    @Override
    public void insert(int index, String element)
    {
        super.set(index, element);
    }

    @Override
    public void push(String value)
    {
        add(value);
    }

}
