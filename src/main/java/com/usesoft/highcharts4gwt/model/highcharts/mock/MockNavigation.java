
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Navigation;
import com.usesoft.highcharts4gwt.model.highcharts.api.navigation.ButtonOptions;

public class MockNavigation
    implements Navigation
{

    private ButtonOptions buttonOptions;

    public ButtonOptions buttonOptions() {
        return buttonOptions;
    }

    public MockNavigation buttonOptions(ButtonOptions buttonOptions) {
        this.buttonOptions = buttonOptions;
        return this;
    }

}
