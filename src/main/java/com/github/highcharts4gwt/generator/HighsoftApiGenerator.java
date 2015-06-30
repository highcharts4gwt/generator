package com.github.highcharts4gwt.generator;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.model.highsoft.Product;
import com.github.highcharts4gwt.generator.model.highsoft.ProductVisitor;

public class HighsoftApiGenerator implements ProductVisitor<Void, Void>
{
    private static final Logger logger = LoggerFactory.getLogger(HighsoftApiGenerator.class);

    @Override
    @CheckForNull
    public Void visitHighcharts(@CheckForNull Void in)
    {
        Generator generator;
        try
        {
            logger.info("Highcharts API generation");
            generator = new OnlineGenerator(Product.Highcharts);
            //generator = new OfflineGenerator(Product.Highcharts);
            generator.generateClasses();
        }
        catch (Exception e)
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
