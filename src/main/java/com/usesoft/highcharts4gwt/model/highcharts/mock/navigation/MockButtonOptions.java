
package com.usesoft.highcharts4gwt.model.highcharts.mock.navigation;

import com.usesoft.highcharts4gwt.model.highcharts.api.navigation.ButtonOptions;

public class MockButtonOptions
    implements ButtonOptions
{

    private String align;
    private boolean enabled;
    private Number height;
    private Number symbolSize;
    private Number symbolStrokeWidth;
    private Number symbolX;
    private Number symbolY;
    private String text;
    private String verticalAlign;
    private Number width;
    private Number y;

    public String align() {
        return align;
    }

    public MockButtonOptions align(String align) {
        this.align = align;
        return this;
    }

    public boolean enabled() {
        return enabled;
    }

    public MockButtonOptions enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Number height() {
        return height;
    }

    public MockButtonOptions height(Number height) {
        this.height = height;
        return this;
    }

    public Number symbolSize() {
        return symbolSize;
    }

    public MockButtonOptions symbolSize(Number symbolSize) {
        this.symbolSize = symbolSize;
        return this;
    }

    public Number symbolStrokeWidth() {
        return symbolStrokeWidth;
    }

    public MockButtonOptions symbolStrokeWidth(Number symbolStrokeWidth) {
        this.symbolStrokeWidth = symbolStrokeWidth;
        return this;
    }

    public Number symbolX() {
        return symbolX;
    }

    public MockButtonOptions symbolX(Number symbolX) {
        this.symbolX = symbolX;
        return this;
    }

    public Number symbolY() {
        return symbolY;
    }

    public MockButtonOptions symbolY(Number symbolY) {
        this.symbolY = symbolY;
        return this;
    }

    public String text() {
        return text;
    }

    public MockButtonOptions text(String text) {
        this.text = text;
        return this;
    }

    public String verticalAlign() {
        return verticalAlign;
    }

    public MockButtonOptions verticalAlign(String verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    public Number width() {
        return width;
    }

    public MockButtonOptions width(Number width) {
        this.width = width;
        return this;
    }

    public Number y() {
        return y;
    }

    public MockButtonOptions y(Number y) {
        this.y = y;
        return this;
    }

}
