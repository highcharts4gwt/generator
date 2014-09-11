package com.usesoft.highcharts4gwt.model.array.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.usesoft.highcharts4gwt.model.array.api.Array;

public class JsoArray<T extends JavaScriptObject> extends JsArray<T> implements Array<T>
{

    protected JsoArray()
    {
    }

    @Override
    final public void insert(int index, T value)
    {
        set(index, value);
    }

    @Override
    public void addToEnd(T value)
    {
        push(value);
    }
}
