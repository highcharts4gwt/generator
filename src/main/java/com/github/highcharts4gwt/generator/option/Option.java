package com.github.highcharts4gwt.generator.option;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.HasReturnType;
import com.github.highcharts4gwt.generator.common.ObjectOrOption;

public class Option extends ObjectOrOption implements HasReturnType
{

    // Constructor with non null values
    public Option(String fullname, String name, String title)
    {
        this.fullname = fullname;
        this.name = name;
        this.title = title;
        this.values = new ArrayList<String>();
    }

    @Override
    public String getFullname()
    {
        return fullname;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    public List<String> getValues()
    {
        return values;
    }

    public Option setValues(List<String> values)
    {
        this.values = values;
        return this;
    }

    @CheckForNull
    public String getDefaults()
    {
        return defaults;
    }

    public Option setDefaults(@CheckForNull String defaults)
    {
        this.defaults = defaults;
        return this;
    }

    @Override
    public boolean isParent()
    {
        return isParent;
    }

    public Option setIsParent(boolean isParent)
    {
        this.isParent = isParent;
        return this;
    }

    @CheckForNull
    public String getSince()
    {
        return since;
    }

    public Option setSince(@CheckForNull String since)
    {
        this.since = since;
        return this;
    }

    @CheckForNull
    public String getDemo()
    {
        return demo;
    }

    public Option setDemo(@CheckForNull String demo)
    {
        this.demo = demo;
        return this;
    }

    public boolean isDeprecated()
    {
        return deprecated;
    }

    public Option setDeprecated(boolean deprecated)
    {
        this.deprecated = deprecated;
        return this;
    }

    @CheckForNull
    public String getSeeAlso()
    {
        return seeAlso;
    }

    public Option setSeeAlso(@CheckForNull String seeAlso)
    {
        this.seeAlso = seeAlso;
        return this;
    }

    @CheckForNull
    public String getParent()
    {
        return parent;
    }

    public Option setParent(@CheckForNull String parent)
    {
        this.parent = parent;
        return this;
    }

    @Override
    @CheckForNull
    public String getReturnType()
    {
        return returnType;
    }

    public Option setReturnType(@CheckForNull String returnType)
    {
        this.returnType = returnType;
        return this;
    }

    @CheckForNull
    public String getDescription()
    {
        return description;
    }

    public Option setDescription(@CheckForNull String description)
    {
        this.description = description;
        return this;
    }

    public String getContext()
    {
        return context;
    }

    public Option setContext(String context)
    {
        this.context = context;
        return this;
    }

    private final String fullname;

    private final String name;

    private final String title;

    private List<String> values;

    @CheckForNull
    private String defaults;

    private boolean isParent;

    @CheckForNull
    private String since;

    @CheckForNull
    private String context;

    @CheckForNull
    private String demo;

    @CheckForNull
    private boolean deprecated;

    @CheckForNull
    private String seeAlso;

    @CheckForNull
    private String parent;

    @CheckForNull
    private String returnType;

    @CheckForNull
    private String description;

    @Override
    public boolean equals(java.lang.Object obj)
    {
        if (!(obj instanceof Option))
            return false;
        return super.equals(obj);
    }
}
