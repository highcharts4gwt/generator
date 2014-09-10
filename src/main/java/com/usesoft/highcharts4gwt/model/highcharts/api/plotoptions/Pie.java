
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.pie.Events;

public interface Pie {


    Number borderWidth();

    Pie borderWidth(Number borderWidth);

    ArrayString center();

    Pie center(ArrayString center);

    Number depth();

    Pie depth(Number depth);

    Number endAngle();

    Pie endAngle(Number endAngle);

    Events events();

    Pie events(Events events);

    boolean ignoreHiddenPoint();

    Pie ignoreHiddenPoint(boolean ignoreHiddenPoint);

    Number minSize();

    Pie minSize(Number minSize);

    boolean showInLegend();

    Pie showInLegend(boolean showInLegend);

    Number slicedOffset();

    Pie slicedOffset(Number slicedOffset);

    Number startAngle();

    Pie startAngle(Number startAngle);

    boolean stickyTracking();

    Pie stickyTracking(boolean stickyTracking);

}
