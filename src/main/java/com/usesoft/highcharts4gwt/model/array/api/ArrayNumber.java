package com.usesoft.highcharts4gwt.model.array.api;

public interface ArrayNumber
{
    double get(int index);

    int length();

    void push(double value);
    
    /**
     * Replacement for native set method
     * 
     * @param index
     * @param value 
     */
    void setValue(int index, double value);
    
    void setLength(int newLength);

}
