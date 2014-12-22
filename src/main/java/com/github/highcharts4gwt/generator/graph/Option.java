package com.github.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Option
{

    // Constructor with non null values
    public Option(String fullname, String name, String title)
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

    public Option setValues(List<String> values)
    {
        this.values = values;
        return this;
    }

    public List<String> getExcluding()
    {
        return excluding;
    }

    public Option setExcluding(List<String> excluding)
    {
        this.excluding = excluding;
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

    @CheckForNull
    public String getExtending()
    {
        return extending;
    }

    public Option setExtending(@CheckForNull String extending)
    {
        this.extending = extending;
        return this;
    }

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
        if (obj instanceof Option)
            return Objects.equal(getFullname(), ((Option) obj).getFullname());
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(getFullname());
    }
}
