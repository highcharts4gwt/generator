
package com.usesoft.highcharts4gwt.model.highcharts.mock;

import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class MockSeries
    implements Series
{

    private ArrayNumber data;
    private String dataURL;
    private String id;
    private Number index;
    private Number legendIndex;
    private String name;
    private String type;
    private Number zIndex;

    public ArrayNumber data() {
        return data;
    }

    public MockSeries data(ArrayNumber data) {
        this.data = data;
        return this;
    }

    public String dataURL() {
        return dataURL;
    }

    public MockSeries dataURL(String dataURL) {
        this.dataURL = dataURL;
        return this;
    }

    public String id() {
        return id;
    }

    public MockSeries id(String id) {
        this.id = id;
        return this;
    }

    public Number index() {
        return index;
    }

    public MockSeries index(Number index) {
        this.index = index;
        return this;
    }

    public Number legendIndex() {
        return legendIndex;
    }

    public MockSeries legendIndex(Number legendIndex) {
        this.legendIndex = legendIndex;
        return this;
    }

    public String name() {
        return name;
    }

    public MockSeries name(String name) {
        this.name = name;
        return this;
    }

    public String type() {
        return type;
    }

    public MockSeries type(String type) {
        this.type = type;
        return this;
    }

    public Number zIndex() {
        return zIndex;
    }

    public MockSeries zIndex(Number zIndex) {
        this.zIndex = zIndex;
        return this;
    }

}
