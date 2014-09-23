package com.usesoft.highcharts4gwt.model.array.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.usesoft.highcharts4gwt.model.array.api.Array;

public class JsoArray<T> extends JsArray<JavaScriptObject> implements Array<T>
{

    protected JsoArray()
    {
    }

    @SuppressWarnings("unchecked")
    @Override
    public final T getItem(int index)
    {
        return (T) get(index);
    }

    @Override
    final public void insert(int index, T value)
    {
        set(index, (JavaScriptObject) value);
    }

    @Override
    final public void addToEnd(T value)
    {
        push((JavaScriptObject) value);
    }
}
