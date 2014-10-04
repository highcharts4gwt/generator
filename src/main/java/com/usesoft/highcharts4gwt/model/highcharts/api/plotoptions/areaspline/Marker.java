
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.areaspline;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.areaspline.marker.States;

public interface Marker {


    boolean enabled();

    Marker enabled(boolean enabled);

    Number height();

    Marker height(Number height);

    Number lineWidth();

    Marker lineWidth(Number lineWidth);

    Number radius();

    Marker radius(Number radius);

    States states();

    Marker states(States states);

    String symbol();

    Marker symbol(String symbol);

    Number width();

    Marker width(Number width);

}
