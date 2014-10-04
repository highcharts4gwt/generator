
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Bubble;
import com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.MockScatter;

public class MockBubble
    extends MockScatter
    implements Bubble
{

    private boolean displayNegative;
    private String maxSize;
    private String minSize;
    private String sizeBy;
    private Number zMax;
    private Number zMin;
    private Number zThreshold;

    public boolean displayNegative() {
        return displayNegative;
    }

    public MockBubble displayNegative(boolean displayNegative) {
        this.displayNegative = displayNegative;
        return this;
    }

    public String maxSize() {
        return maxSize;
    }

    public MockBubble maxSize(String maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    public String minSize() {
        return minSize;
    }

    public MockBubble minSize(String minSize) {
        this.minSize = minSize;
        return this;
    }

    public String sizeBy() {
        return sizeBy;
    }

    public MockBubble sizeBy(String sizeBy) {
        this.sizeBy = sizeBy;
        return this;
    }

    public Number zMax() {
        return zMax;
    }

    public MockBubble zMax(Number zMax) {
        this.zMax = zMax;
        return this;
    }

    public Number zMin() {
        return zMin;
    }

    public MockBubble zMin(Number zMin) {
        this.zMin = zMin;
        return this;
    }

    public Number zThreshold() {
        return zThreshold;
    }

    public MockBubble zThreshold(Number zThreshold) {
        this.zThreshold = zThreshold;
        return this;
    }

}
