package com.usesoft.gwthighcharts.client.widget;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class HighchartsLayoutPanel extends SimpleLayoutPanel {

	// -- Rendering flow --
	// onLoad
	// onResized
	// on attach or detach event
	// onAttach

	public HighchartsLayoutPanel() {
		id = HTMLPanel.createUniqueId();
		this.getElement().setId(id);
	}

	private String id;

	public void setChart(JavaScriptObject options) {
		drawChart(id, options);
	}

	private native JavaScriptObject drawChart(String containerId,JavaScriptObject options) 
	/*-{
		return $wnd.jQuery('#'+containerId).highcharts(options);
	}-*/;
}
