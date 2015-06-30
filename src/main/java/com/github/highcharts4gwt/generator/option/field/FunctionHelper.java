package com.github.highcharts4gwt.generator.option.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.option.Option;
import com.sun.codemodel.JClass;

public class FunctionHelper
{
    private static final Logger logger = LoggerFactory.getLogger(FunctionHelper.class);

    private FunctionHelper()
    {
    }

    public static String getFunctionCallbackFqn(Option option, String packageName)
    {
        String titleInCc = option.getTitle().substring(0, 1).toUpperCase() + option.getTitle().substring(1);
        String fqn = packageName + "." + titleInCc + "Callback";
        return fqn;
    }

    public static JClass getContextObject(Option option, OutputType outputType)
    {
        String context = option.getContext();
        if (context == null)
            return null;
        if (context.contains("|"))
        {
            logger.warn("Do not support function with 2 context type; option;" + option);
            return null;
        }
        else if (context.equals(""))
        {
            logger.warn("Do not support function with context object empty;option;" + option);
            return null;
        }
        
        com.github.highcharts4gwt.generator.object.Object contextObjectKey = new com.github.highcharts4gwt.generator.object.Object(context, "", "");
        
        return ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(contextObjectKey, outputType));

    }
}
