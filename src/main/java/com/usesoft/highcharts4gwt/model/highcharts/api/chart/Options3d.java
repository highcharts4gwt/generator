
package com.usesoft.highcharts4gwt.model.highcharts.api.chart;

import com.usesoft.highcharts4gwt.model.highcharts.api.chart.options3d.Frame;

public interface Options3d {


    Number alpha();

    Options3d alpha(Number alpha);

    Number beta();

    Options3d beta(Number beta);

    Number depth();

    Options3d depth(Number depth);

    boolean enabled();

    Options3d enabled(boolean enabled);

    Frame frame();

    Options3d frame(Frame frame);

    Number viewDistance();

    Options3d viewDistance(Number viewDistance);

}
