package com.usesoft.highcharts4gwt.model.array.api;

public interface Array<T>
{
    T get(int index);

    int length();

    void addToEnd(T value); // Cannot use JsArray method name otherwise error overload using erasure

    void insert(int index, T value);
}
