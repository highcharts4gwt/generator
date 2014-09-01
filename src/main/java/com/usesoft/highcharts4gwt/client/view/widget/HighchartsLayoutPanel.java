package com.usesoft.highcharts4gwt.client.view.widget;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.usesoft.highcharts4gwt.model.api.Options;

public class HighchartsLayoutPanel extends SimpleLayoutPanel
{

    // -- Rendering flow --
    // onLoad
    // onResized
    // on attach or detach event
    // onAttach

    public HighchartsLayoutPanel()
    {
        id = HTMLPanel.createUniqueId();
        this.getElement().setId(id);
    }

    private final String id;

    public JavaScriptObject renderChart(Options options)
    {
        return drawChart(id, options);
    }

    private native JavaScriptObject drawChart(String containerId, Options options)
    /*-{
    	return $wnd.jQuery('#'+containerId).highcharts(options);
    }-*/;
}
