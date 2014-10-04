
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Scatter;

public interface Bubble
    extends Scatter
{


    boolean displayNegative();

    Bubble displayNegative(boolean displayNegative);

    String maxSize();

    Bubble maxSize(String maxSize);

    String minSize();

    Bubble minSize(String minSize);

    String sizeBy();

    Bubble sizeBy(String sizeBy);

    Number zMax();

    Bubble zMax(Number zMax);

    Number zMin();

    Bubble zMin(Number zMin);

    Number zThreshold();

    Bubble zThreshold(Number zThreshold);

}
