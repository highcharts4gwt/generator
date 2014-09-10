package com.usesoft.highcharts4gwt.model.array.api;

public interface ArrayNumber
{
    double get(int index);

    int length();

    void push(double value);

    void insert(int index, double value);

}
