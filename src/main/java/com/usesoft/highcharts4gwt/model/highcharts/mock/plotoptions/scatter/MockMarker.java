
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.scatter;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.Marker;
import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.marker.States;

public class MockMarker
    implements Marker
{

    private boolean enabled;
    private Number height;
    private Number lineWidth;
    private Number radius;
    private States states;
    private String symbol;
    private Number width;

    public boolean enabled() {
        return enabled;
    }

    public MockMarker enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Number height() {
        return height;
    }

    public MockMarker height(Number height) {
        this.height = height;
        return this;
    }

    public Number lineWidth() {
        return lineWidth;
    }

    public MockMarker lineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public Number radius() {
        return radius;
    }

    public MockMarker radius(Number radius) {
        this.radius = radius;
        return this;
    }

    public States states() {
        return states;
    }

    public MockMarker states(States states) {
        this.states = states;
        return this;
    }

    public String symbol() {
        return symbol;
    }

    public MockMarker symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public Number width() {
        return width;
    }

    public MockMarker width(Number width) {
        this.width = width;
        return this;
    }

}
