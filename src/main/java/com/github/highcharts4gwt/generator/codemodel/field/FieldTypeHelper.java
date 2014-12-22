package com.github.highcharts4gwt.generator.codemodel.field;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.highcharts4gwt.generator.graph.Option;
import com.google.common.base.Strings;

public class FieldTypeHelper
{
    public static final Pattern SIMPLE_REGEXP = Pattern.compile("(\\w+)");
    public static final Pattern PIPE_REGEXP = Pattern.compile("(\\w+)\\s*(?:\\|\\s*(\\w+))+");
    public static final Pattern ARRAY_REGEXP = Pattern.compile("Array\\s*<\\s*(\\w+)\\s*>");
    public static final Pattern ARRAY_PIPE_REGEXP = Pattern.compile("Array\\s*<\\s*(\\w+)\\s*(?:\\|\\s*(\\w+)\\s*)+>");

    private FieldTypeHelper()
    {
    }

    public static List<FieldType> findTypes(Option option)
    {
        String returnType = option.getReturnType();

        ReturnTypeCategory category = getCategory(returnType);

        return category.accept(new FieldTypesVisitor(category.getMatcher()), option);
    }

    private static ReturnTypeCategory getCategory(String returnType)
    {
        if (!Strings.isNullOrEmpty(returnType))
        {
            Matcher matcherArrayPipe = ARRAY_PIPE_REGEXP.matcher(returnType);
            if (matcherArrayPipe.matches())
            {
                ReturnTypeCategory.ArrayWithPipe.setMatcher(matcherArrayPipe);
                return ReturnTypeCategory.ArrayWithPipe;
            }

            Matcher matcherArray = ARRAY_REGEXP.matcher(returnType);
            if (matcherArray.matches())
            {
                ReturnTypeCategory.Array.setMatcher(matcherArray);
                return ReturnTypeCategory.Array;
            }

            Matcher matcherPipe = PIPE_REGEXP.matcher(returnType);
            if (matcherPipe.matches())
            {
                ReturnTypeCategory.SimpleWithPipe.setMatcher(matcherPipe);
                return ReturnTypeCategory.SimpleWithPipe;
            }

            Matcher matcherSimple = SIMPLE_REGEXP.matcher(returnType);
            if (matcherSimple.matches())
            {
                ReturnTypeCategory.Simple.setMatcher(matcherSimple);
                return ReturnTypeCategory.Simple;
            }

            // TODO set a new Unknown category
        }
        ReturnTypeCategory.Simple.setMatcher(null);
        return ReturnTypeCategory.Simple;
    }
}
