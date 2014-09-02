package com.usesoft.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class OptionSpec
{

    // Constructor with non null values
    public OptionSpec(String fullname, String name, String title)
    {
        this.fullname = fullname;
        this.name = name;
        this.title = title;
        this.values = new ArrayList<String>();
        this.excluding = new ArrayList<String>();
    }

    public String getFullname()
    {
        return fullname;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }

    public List<String> getValues()
    {
        return values;
    }

    public OptionSpec setValues(List<String> values)
    {
        this.values = values;
        return this;
    }

    public List<String> getExcluding()
    {
        return excluding;
    }

    public OptionSpec setExcluding(List<String> excluding)
    {
        this.excluding = excluding;
        return this;
    }

    @CheckForNull
    public String getDefaults()
    {
        return defaults;
    }

    public OptionSpec setDefaults(@CheckForNull String defaults)
    {
        this.defaults = defaults;
        return this;
    }

    @CheckForNull
    public String getExtending()
    {
        return extending;
    }

    @CheckForNull
    public OptionSpec setExtending(@CheckForNull String extending)
    {
        this.extending = extending;
        return this;
    }

    public boolean isParent()
    {
        return isParent;
    }

    public OptionSpec setIsParent(boolean isParent)
    {
        this.isParent = isParent;
        return this;
    }

    @CheckForNull
    public String getSince()
    {
        return since;
    }

    @CheckForNull
    public OptionSpec setSince(@CheckForNull String since)
    {
        this.since = since;
        return this;
    }

    @CheckForNull
    public String getDemo()
    {
        return demo;
    }

    @CheckForNull
    public OptionSpec setDemo(@CheckForNull String demo)
    {
        this.demo = demo;
        return this;
    }

    public boolean isDeprecated()
    {
        return deprecated;
    }

    public OptionSpec setDeprecated(boolean deprecated)
    {
        this.deprecated = deprecated;
        return this;
    }

    @CheckForNull
    public String getSeeAlso()
    {
        return seeAlso;
    }

    public OptionSpec setSeeAlso(@CheckForNull String seeAlso)
    {
        this.seeAlso = seeAlso;
        return this;
    }

    @CheckForNull
    public String getParent()
    {
        return parent;
    }

    public OptionSpec setParent(@CheckForNull String parent)
    {
        this.parent = parent;
        return this;
    }

    @CheckForNull
    public String getReturnType()
    {
        return returnType;
    }

    public OptionSpec setReturnType(@CheckForNull String returnType)
    {
        this.returnType = returnType;
        return this;
    }

    @CheckForNull
    public String getDescription()
    {
        return description;
    }

    public OptionSpec setDescription(@CheckForNull String description)
    {
        this.description = description;
        return this;
    }

    private final String fullname;

    private final String name;

    private final String title;

    private List<String> values;

    private List<String> excluding;

    @CheckForNull
    private String defaults;

    @CheckForNull
    private String extending;

    private boolean isParent;

    @CheckForNull
    private String since;

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
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("fullName", getFullname()).toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (obj instanceof OptionSpec)
            return Objects.equal(getFullname(), ((OptionSpec) obj).getFullname());
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(getFullname());
    }
}
