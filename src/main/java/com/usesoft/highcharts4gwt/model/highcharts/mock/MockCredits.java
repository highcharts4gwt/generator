
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Credits;

public class MockCredits
    implements Credits
{

    private boolean enabled;
    private String href;
    private String text;

    public boolean enabled() {
        return enabled;
    }

    public MockCredits enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String href() {
        return href;
    }

    public MockCredits href(String href) {
        this.href = href;
        return this;
    }

    public String text() {
        return text;
    }

    public MockCredits text(String text) {
        this.text = text;
        return this;
    }

}
