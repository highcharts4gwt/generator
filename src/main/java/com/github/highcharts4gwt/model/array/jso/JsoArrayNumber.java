package com.github.highcharts4gwt.model.array.jso;

import com.github.highcharts4gwt.model.array.api.ArrayNumber;
import com.google.gwt.core.client.JsArrayNumber;

public class JsoArrayNumber extends JsArrayNumber implements ArrayNumber
{

    protected JsoArrayNumber()
    {
    }

    @Override
    final public void setValue(int index, double value)
    {
        set(index, value);
    }
}
