package com.usesoft.highcharts4gwt.client.view.widget;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.usesoft.highcharts4gwt.generated.highcharts.api.ChartOptions;

public class HighchartsLayoutPanel extends SimpleLayoutPanel
{

    public HighchartsLayoutPanel()
    {
        id = HTMLPanel.createUniqueId();
        this.getElement().setId(id);
    }

    // -- Rendering flow --
    // onLoad
    // onResized
    // on attach or detach event
    // onAttach

    private final String id;

    public JavaScriptObject renderChart(ChartOptions options)
    {
        return drawChart(id, options);
    }

    private native JavaScriptObject drawChart(String containerId, ChartOptions options)
    /*-{
        return $wnd.jQuery('#'+containerId).highcharts(options);
    }-*/;
}
