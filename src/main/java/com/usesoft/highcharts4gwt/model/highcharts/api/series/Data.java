
package com.usesoft.highcharts4gwt.model.highcharts.api.series;

import com.usesoft.highcharts4gwt.model.highcharts.api.series.data.Marker;

public interface Data {


    String drilldown();

    Data drilldown(String drilldown);

    String id();

    Data id(String id);

    boolean isIntermediateSum();

    Data isIntermediateSum(boolean isIntermediateSum);

    boolean isSum();

    Data isSum(boolean isSum);

    Number legendIndex();

    Data legendIndex(Number legendIndex);

    Marker marker();

    Data marker(Marker marker);

    String name();

    Data name(String name);

    boolean sliced();

    Data sliced(boolean sliced);

    Number x();

    Data x(Number x);

    Number y();

    Data y(Number y);

}
