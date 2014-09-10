
package com.usesoft.highcharts4gwt.model.highcharts.api;

import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;

public interface Series {


    ArrayNumber data();

    Series data(ArrayNumber data);

    String dataURL();

    Series dataURL(String dataURL);

    String id();

    Series id(String id);

    Number index();

    Series index(Number index);

    Number legendIndex();

    Series legendIndex(Number legendIndex);

    String name();

    Series name(String name);

    String type();

    Series type(String type);

    Number zIndex();

    Series zIndex(Number zIndex);

}
