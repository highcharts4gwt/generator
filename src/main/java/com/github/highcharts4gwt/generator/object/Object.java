package com.github.highcharts4gwt.generator.object;

import javax.annotation.CheckForNull;

import com.github.highcharts4gwt.generator.common.HasReturnType;
import com.github.highcharts4gwt.generator.common.ObjectOrOption;

public class Object extends ObjectOrOption implements HasReturnType
{
    // Constructor with non null values
    public Object(String fullname, String name, String title)
    {
        this.fullname = fullname;
        this.name = name;
        this.title = title;
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

    @Override
    public boolean isParent()
    {
        return isParent;
    }

    public Object setIsParent(boolean isParent)
    {
        this.isParent = isParent;
        return this;
    }

    @CheckForNull
    public String getSince()
    {
        return since;
    }

    public Object setSince(@CheckForNull String since)
    {
        this.since = since;
        return this;
    }

    @CheckForNull
    public String getDemo()
    {
        return demo;
    }

    public Object setDemo(@CheckForNull String demo)
    {
        this.demo = demo;
        return this;
    }

    public boolean isDeprecated()
    {
        return deprecated;
    }

    public Object setDeprecated(boolean deprecated)
    {
        this.deprecated = deprecated;
        return this;
    }

    @CheckForNull
    public String getType()
    {
        return type;
    }

    public Object setType(@CheckForNull String type)
    {
        this.type = type;
        return this;
    }

    @CheckForNull
    public String getParams()
    {
        return params;
    }

    public Object setParams(@CheckForNull String params)
    {
        this.params = params;
        return this;
    }

    @CheckForNull
    public String getParamsDescription()
    {
        return paramsDescription;
    }

    public Object setParamsDescription(@CheckForNull String paramsDescription)
    {
        this.paramsDescription = paramsDescription;
        return this;
    }

    @CheckForNull
    public String getParent()
    {
        return parent;
    }

    public Object setParent(@CheckForNull String parent)
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

    public Object setReturnType(@CheckForNull String returnType)
    {
        this.returnType = returnType;
        return this;
    }

    @CheckForNull
    public String getDescription()
    {
        return description;
    }

    public Object setDescription(@CheckForNull String description)
    {
        this.description = description;
        return this;
    }

    private final String fullname;

    private final String name;

    private final String title;

    private boolean isParent;

    @CheckForNull
    private String type;

    @CheckForNull
    private String since;

    @CheckForNull
    private String demo;

    @CheckForNull
    private boolean deprecated;

    @CheckForNull
    private String parent;

    @CheckForNull
    private String returnType;

    @CheckForNull
    private String description;

    @CheckForNull
    private String params;

    @CheckForNull
    private String paramsDescription;

    @Override
    public boolean equals(java.lang.Object obj)
    {
        if (!(obj instanceof Object))
            return false;
        return super.equals(obj);
    }
}
