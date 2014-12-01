package com.usesoft.highcharts4gwt.model.array.jso;

import com.google.gwt.core.client.JsArrayString;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;

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
