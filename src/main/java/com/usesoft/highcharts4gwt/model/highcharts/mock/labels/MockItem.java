
package com.usesoft.highcharts4gwt.model.highcharts.mock.labels;

import com.usesoft.highcharts4gwt.model.highcharts.api.labels.Item;

public class MockItem
    implements Item
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
