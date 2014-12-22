package com.github.highcharts4gwt.model.array.jso;

import com.github.highcharts4gwt.model.array.api.ArrayString;
import com.google.gwt.core.client.JsArrayString;

public class JsoArrayString extends JsArrayString implements ArrayString
{

    protected JsoArrayString()
    {
    }

    @Override
    final public void setValue(int index, String value)
    {
        set(index, value);
    }
}
