package com.usesoft.highcharts4gwt.generator;

import javax.annotation.CheckForNull;

import com.usesoft.highcharts4gwt.generator.highsoft.Product;
import com.usesoft.highcharts4gwt.generator.highsoft.ProductVisitor;

public class HighsoftApiGenerator implements ProductVisitor<Void, Void>
{

    @Override
    @CheckForNull
    public Void visitHighcharts(@CheckForNull Void in)
    {
        Generator generator;
        try
        {
            // generator = new OnlineGenerator(Product.Highcharts);
            generator = new OfflineGenerator(Product.Highcharts);
            generator.generate();
        } catch (Exception e)
        {
            throw new RuntimeException("Could not generate sources.", e);
        }

        return null;
    }

    @Override
    @CheckForNull
    public Void visitHighmaps(@CheckForNull Void in)
    {
        return null;
    }

    @Override
    @CheckForNull
    public Void visitHighstock(@CheckForNull Void in)
    {
        return null;
    }

}
