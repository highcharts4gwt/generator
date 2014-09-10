
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.highcharts.api.Exporting;
import com.usesoft.highcharts4gwt.model.highcharts.api.exporting.Buttons;

public class MockExporting
    implements Exporting
{

    private Buttons buttons;
    private boolean enabled;
    private String filename;
    private Number scale;
    private Number sourceHeight;
    private Number sourceWidth;
    private String type;
    private String url;
    private Number width;

    public Buttons buttons() {
        return buttons;
    }

    public MockExporting buttons(Buttons buttons) {
        this.buttons = buttons;
        return this;
    }

    public boolean enabled() {
        return enabled;
    }

    public MockExporting enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String filename() {
        return filename;
    }

    public MockExporting filename(String filename) {
        this.filename = filename;
        return this;
    }

    public Number scale() {
        return scale;
    }

    public MockExporting scale(Number scale) {
        this.scale = scale;
        return this;
    }

    public Number sourceHeight() {
        return sourceHeight;
    }

    public MockExporting sourceHeight(Number sourceHeight) {
        this.sourceHeight = sourceHeight;
        return this;
    }

    public Number sourceWidth() {
        return sourceWidth;
    }

    public MockExporting sourceWidth(Number sourceWidth) {
        this.sourceWidth = sourceWidth;
        return this;
    }

    public String type() {
        return type;
    }

    public MockExporting type(String type) {
        this.type = type;
        return this;
    }

    public String url() {
        return url;
    }

    public MockExporting url(String url) {
        this.url = url;
        return this;
    }

    public Number width() {
        return width;
    }

    public MockExporting width(Number width) {
        this.width = width;
        return this;
    }

}
