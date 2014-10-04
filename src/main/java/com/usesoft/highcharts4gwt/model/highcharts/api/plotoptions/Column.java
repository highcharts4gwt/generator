
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Series;

public interface Column
    extends Series
{


    Number borderRadius();

    Column borderRadius(Number borderRadius);

    Number borderWidth();

    Column borderWidth(Number borderWidth);

    boolean colorByPoint();

    Column colorByPoint(boolean colorByPoint);

    Number depth();

    Column depth(Number depth);

    Number edgeWidth();

    Column edgeWidth(Number edgeWidth);

    Number groupPadding();

    Column groupPadding(Number groupPadding);

    Number groupZPadding();

    Column groupZPadding(Number groupZPadding);

    boolean grouping();

    Column grouping(boolean grouping);

    Number minPointLength();

    Column minPointLength(Number minPointLength);

    Number pointPadding();

    Column pointPadding(Number pointPadding);

    Number pointRange();

    Column pointRange(Number pointRange);

    Number pointWidth();

    Column pointWidth(Number pointWidth);

}
