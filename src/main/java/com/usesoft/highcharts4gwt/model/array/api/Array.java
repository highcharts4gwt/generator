package com.usesoft.highcharts4gwt.model.array.api;

public interface Array<T>
{
    T get(int index);

    int length();

    void push(T value);

    void insert(int index, T value);
}
