package com.usesoft.highcharts4gwt.model.array.api;

public interface ArrayString
{
    String get(int index);

    int length();

    void push(String value);
    

    /**
     * Replacement for native set method
     * 
     * @param index
     * @param value 
     */
    void setValue(int index, String value);
    
    void setLength(int newLength);

}
