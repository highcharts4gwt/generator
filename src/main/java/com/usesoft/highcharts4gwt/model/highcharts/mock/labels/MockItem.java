
package com.usesoft.highcharts4gwt.model.highcharts.mock.labels;

import com.usesoft.highcharts4gwt.model.highcharts.api.labels.Items;

public class MockItem
    implements Items
{

    private String html;

    public String html() {
        return html;
    }

    public MockItem html(String html) {
        this.html = html;
        return this;
    }

}
