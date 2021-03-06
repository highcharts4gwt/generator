package com.github.highcharts4gwt.generator;

import com.github.highcharts4gwt.generator.model.highsoft.Product;

public class Main
{
    private Main()
    {
    }

    public static void main(String[] args)
    {
        try
        {
            HighsoftApiGenerator visitor = new HighsoftApiGenerator();

            // Only generate for highcharts right now;
            Product.Highcharts.accept(visitor, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
