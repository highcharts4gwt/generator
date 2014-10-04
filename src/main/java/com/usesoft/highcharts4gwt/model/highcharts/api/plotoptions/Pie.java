
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;

public interface Pie
    extends Series
{


    Number borderWidth();

    Pie borderWidth(Number borderWidth);

    ArrayString center();

    Pie center(ArrayString center);

    Number depth();

    Pie depth(Number depth);

    Number endAngle();

    Pie endAngle(Number endAngle);

    boolean ignoreHiddenPoint();

    Pie ignoreHiddenPoint(boolean ignoreHiddenPoint);

    Number minSize();

    Pie minSize(Number minSize);

    Number slicedOffset();

    Pie slicedOffset(Number slicedOffset);

    Number startAngle();

    Pie startAngle(Number startAngle);

}
