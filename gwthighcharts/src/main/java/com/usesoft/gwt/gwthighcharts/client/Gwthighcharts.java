package com.usesoft.gwt.gwthighcharts.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Gwthighcharts implements EntryPoint {

    public void onModuleLoad() {
        RootLayoutPanel.get().add(new Label("Hello World"));
    }
}
