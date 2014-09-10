
package com.usesoft.highcharts4gwt.model.highcharts.mock.labels;

import com.usesoft.highcharts4gwt.model.highcharts.api.labels.Items;

public class MockItems
    implements Items
{

    private String html;

    public String html() {
        return html;
    }

    public MockItems html(String html) {
        this.html = html;
        return this;
    }

}
