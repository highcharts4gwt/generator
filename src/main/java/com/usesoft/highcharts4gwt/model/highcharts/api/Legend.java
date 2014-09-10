
package com.usesoft.highcharts4gwt.model.highcharts.api;

import com.usesoft.highcharts4gwt.model.highcharts.api.legend.Navigation;

public interface Legend {


    String align();

    Legend align(String align);

    Number borderRadius();

    Legend borderRadius(Number borderRadius);

    Number borderWidth();

    Legend borderWidth(Number borderWidth);

    boolean enabled();

    Legend enabled(boolean enabled);

    boolean floating();

    Legend floating(boolean floating);

    Number itemDistance();

    Legend itemDistance(Number itemDistance);

    Number itemMarginBottom();

    Legend itemMarginBottom(Number itemMarginBottom);

    Number itemMarginTop();

    Legend itemMarginTop(Number itemMarginTop);

    Number itemWidth();

    Legend itemWidth(Number itemWidth);

    String labelFormat();

    Legend labelFormat(String labelFormat);

    String layout();

    Legend layout(String layout);

    Number lineHeight();

    Legend lineHeight(Number lineHeight);

    Number margin();

    Legend margin(Number margin);

    Number maxHeight();

    Legend maxHeight(Number maxHeight);

    Navigation navigation();

    Legend navigation(Navigation navigation);

    Number padding();

    Legend padding(Number padding);

    boolean reversed();

    Legend reversed(boolean reversed);

    boolean rtl();

    Legend rtl(boolean rtl);

    Number symbolHeight();

    Legend symbolHeight(Number symbolHeight);

    Number symbolPadding();

    Legend symbolPadding(Number symbolPadding);

    Number symbolRadius();

    Legend symbolRadius(Number symbolRadius);

    Number symbolWidth();

    Legend symbolWidth(Number symbolWidth);

    boolean useHTML();

    Legend useHTML(boolean useHTML);

    String verticalAlign();

    Legend verticalAlign(String verticalAlign);

    Number width();

    Legend width(Number width);

    Number x();

    Legend x(Number x);

    Number y();

    Legend y(Number y);

}
