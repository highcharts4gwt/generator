
package com.usesoft.highcharts4gwt.model.highcharts.api;


public interface Tooltip {


    boolean animation();

    Tooltip animation(boolean animation);

    Number borderRadius();

    Tooltip borderRadius(Number borderRadius);

    Number borderWidth();

    Tooltip borderWidth(Number borderWidth);

    boolean enabled();

    Tooltip enabled(boolean enabled);

    boolean followPointer();

    Tooltip followPointer(boolean followPointer);

    boolean followTouchMove();

    Tooltip followTouchMove(boolean followTouchMove);

    String footerFormat();

    Tooltip footerFormat(String footerFormat);

    String headerFormat();

    Tooltip headerFormat(String headerFormat);

    Number hideDelay();

    Tooltip hideDelay(Number hideDelay);

    String pointFormat();

    Tooltip pointFormat(String pointFormat);

    boolean shadow();

    Tooltip shadow(boolean shadow);

    String shape();

    Tooltip shape(String shape);

    boolean shared();

    Tooltip shared(boolean shared);

    Number snap();

    Tooltip snap(Number snap);

    boolean useHTML();

    Tooltip useHTML(boolean useHTML);

    Number valueDecimals();

    Tooltip valueDecimals(Number valueDecimals);

    String valuePrefix();

    Tooltip valuePrefix(String valuePrefix);

    String valueSuffix();

    Tooltip valueSuffix(String valueSuffix);

    String xDateFormat();

    Tooltip xDateFormat(String xDateFormat);

}
