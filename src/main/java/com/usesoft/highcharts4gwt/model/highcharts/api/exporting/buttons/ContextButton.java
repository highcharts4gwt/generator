
package com.usesoft.highcharts4gwt.model.highcharts.api.exporting.buttons;

import com.usesoft.highcharts4gwt.model.highcharts.api.navigation.ButtonOptions;

public interface ContextButton
    extends ButtonOptions
{


    String symbol();

    ContextButton symbol(String symbol);

    Number x();

    ContextButton x(Number x);

}
