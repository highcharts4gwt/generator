
package com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Column;

public interface Boxplot
    extends Column
{


    Number medianWidth();

    Boxplot medianWidth(Number medianWidth);

    String stemDashStyle();

    Boxplot stemDashStyle(String stemDashStyle);

    Number stemWidth();

    Boxplot stemWidth(Number stemWidth);

    Number whiskerWidth();

    Boxplot whiskerWidth(Number whiskerWidth);

}
