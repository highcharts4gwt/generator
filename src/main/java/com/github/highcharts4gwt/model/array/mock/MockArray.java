package com.github.highcharts4gwt.model.array.mock;

import java.util.ArrayList;

import com.github.highcharts4gwt.model.array.api.Array;

public class MockArray<T> extends ArrayList<T> implements Array<T>
{
    private static final long serialVersionUID = 1L;

    @Override
    public T getItem(int index)
    {
        return get(index);
    }

    @Override
    public int length()
    {
        return size();
    }

    @Override
    public void setValue(int index, T element)
    {
        super.set(index, element);
    }

    @Override
    public void addToEnd(T value)
    {
        add(value);
    }

    @Override
    public void setLength(int newLength)
    {
    }

}
