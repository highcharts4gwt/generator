
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Errorbar;

public class MockErrorbar
    implements Errorbar
{

    private String linkedTo;
    private Number whiskerWidth;

    public String linkedTo() {
        return linkedTo;
    }

    public MockErrorbar linkedTo(String linkedTo) {
        this.linkedTo = linkedTo;
        return this;
    }

    public Number whiskerWidth() {
        return whiskerWidth;
    }

    public MockErrorbar whiskerWidth(Number whiskerWidth) {
        this.whiskerWidth = whiskerWidth;
        return this;
    }

}
