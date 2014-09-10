
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Loading;

public class MockLoading
    implements Loading
{

    private Number hideDuration;
    private Number showDuration;

    public Number hideDuration() {
        return hideDuration;
    }

    public MockLoading hideDuration(Number hideDuration) {
        this.hideDuration = hideDuration;
        return this;
    }

    public Number showDuration() {
        return showDuration;
    }

    public MockLoading showDuration(Number showDuration) {
        this.showDuration = showDuration;
        return this;
    }

}
