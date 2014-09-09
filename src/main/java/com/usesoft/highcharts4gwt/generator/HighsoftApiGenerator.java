package com.usesoft.highcharts4gwt.generator;

import javax.annotation.CheckForNull;

import com.usesoft.highcharts4gwt.generator.highsoft.ProductVisitor;

public class HighsoftApiGenerator implements ProductVisitor<Void, Void>
{

    @CheckForNull
    public Void visitHighcharts(@CheckForNull Void in)
    {
        HighchartsGenerator generator;
        try
        {
            generator = new HighchartsGenerator();
            generator.generate();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Could not generate sources.", e);
        }

        return null;
    }

    @CheckForNull
    public Void visitHighmaps(@CheckForNull Void in)
    {
        return null;
    }

    @CheckForNull
    public Void visitHighstock(@CheckForNull Void in)
    {
        return null;
    }

}
