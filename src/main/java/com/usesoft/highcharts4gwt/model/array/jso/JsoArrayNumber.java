package com.usesoft.highcharts4gwt.model.array.jso;

import com.google.gwt.core.client.JsArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;

public class JsoArrayNumber extends JsArrayNumber implements ArrayNumber
{

    protected JsoArrayNumber()
    {
    }

    @Override
    final public void insert(int index, double value)
    {
        set(index, value);
    }
}
