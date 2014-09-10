
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Global;

public class MockGlobal
    implements Global
{

    private String VMLRadialGradientURL;
    private String canvasToolsURL;
    private Number timezoneOffset;
    private boolean useUTC;

    public String VMLRadialGradientURL() {
        return VMLRadialGradientURL;
    }

    public MockGlobal VMLRadialGradientURL(String VMLRadialGradientURL) {
        this.VMLRadialGradientURL = VMLRadialGradientURL;
        return this;
    }

    public String canvasToolsURL() {
        return canvasToolsURL;
    }

    public MockGlobal canvasToolsURL(String canvasToolsURL) {
        this.canvasToolsURL = canvasToolsURL;
        return this;
    }

    public Number timezoneOffset() {
        return timezoneOffset;
    }

    public MockGlobal timezoneOffset(Number timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
        return this;
    }

    public boolean useUTC() {
        return useUTC;
    }

    public MockGlobal useUTC(boolean useUTC) {
        this.useUTC = useUTC;
        return this;
    }

}
