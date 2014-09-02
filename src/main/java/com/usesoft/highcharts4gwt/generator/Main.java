package com.usesoft.highcharts4gwt.generator;

public class Main
{
    private Main()
    {
    }

    public static void main(String[] args)
    {

        Generator generator = new Generator();
        try
        {
            generator.generate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
