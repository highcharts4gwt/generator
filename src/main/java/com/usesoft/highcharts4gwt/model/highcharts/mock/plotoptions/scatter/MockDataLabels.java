
package com.usesoft.highcharts4gwt.model.highcharts.mock.plotoptions.scatter;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.scatter.DataLabels;
import com.usesoft.highcharts4gwt.model.highcharts.mock.xaxis.MockLabels;

public class MockDataLabels
    extends MockLabels
    implements DataLabels
{

    private Number borderRadius;
    private Number borderWidth;
    private boolean crop;
    private boolean defer;
    private boolean inside;
    private Number padding;
    private String verticalAlign;

    public Number borderRadius() {
        return borderRadius;
    }

    public MockDataLabels borderRadius(Number borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public Number borderWidth() {
        return borderWidth;
    }

    public MockDataLabels borderWidth(Number borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public boolean crop() {
        return crop;
    }

    public MockDataLabels crop(boolean crop) {
        this.crop = crop;
        return this;
    }

    public boolean defer() {
        return defer;
    }

    public MockDataLabels defer(boolean defer) {
        this.defer = defer;
        return this;
    }

    public boolean inside() {
        return inside;
    }

    public MockDataLabels inside(boolean inside) {
        this.inside = inside;
        return this;
    }

    public Number padding() {
        return padding;
    }

    public MockDataLabels padding(Number padding) {
        this.padding = padding;
        return this;
    }

    public String verticalAlign() {
        return verticalAlign;
    }

    public MockDataLabels verticalAlign(String verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

}
