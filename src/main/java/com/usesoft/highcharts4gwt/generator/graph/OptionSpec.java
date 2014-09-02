package com.usesoft.highcharts4gwt.generator.graph;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

public class OptionSpec
{
    // {
    // values: null,
    // fullname: "global.VMLRadialGradientURL",
    // defaults:
    // "http://code.highcharts.com/{version}/gfx/vml-radial-gradient.png",
    // title: "VMLRadialGradientURL",
    // extending: "",
    // excluding: "",
    // isParent: false,
    // since: "2.3.0",
    // demo: "",
    // deprecated: false,
    // seeAlso: "",
    // name: "global--VMLRadialGradientURL",
    // parent: "global",
    // returnType: "String",
    // description:
    // "Path to the pattern image required by VML browsers in order to draw radial gradients."
    // }

    // Constructor with non null values
    public OptionSpec(String fullname, String name, String title)
    {
        this.fullname = fullname;
        this.name = name;
        this.title = title;
        this.values = new ArrayList<String>();
    }

    public String getFullname()
    {
        return fullname;
    }

    // public OptionNode setFullname(String fullname)
    // {
    // this.fullname = fullname;
    // return this;
    // }

    public String getName()
    {
        return name;
    }

    // public OptionNode setName(String name)
    // {
    // this.name = name;
    // return this;
    // }

    public String getTitle()
    {
        return title;
    }

    // public OptionNode setTitle(String title)
    // {
    // this.title = title;
    // return this;
    // }

    public List<String> getValues()
    {
        return values;
    }

    public OptionSpec setValues(List<String> values)
    {
        this.values = values;
        return this;
    }

    public String getDefaults()
    {
        return defaults;
    }

    public OptionSpec setDefaults(String defaults)
    {
        this.defaults = defaults;
        return this;
    }

    public String getExtending()
    {
        return extending;
    }

    public OptionSpec setExtending(String extending)
    {
        this.extending = extending;
        return this;
    }

    public String getExcluding()
    {
        return excluding;
    }

    public OptionSpec setExcluding(String excluding)
    {
        this.excluding = excluding;
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

    public String getSince()
    {
        return since;
    }

    public OptionSpec setSince(String since)
    {
        this.since = since;
        return this;
    }

    public String getDemo()
    {
        return demo;
    }

    public OptionSpec setDemo(String demo)
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

    public String getSeeAlso()
    {
        return seeAlso;
    }

    public OptionSpec setSeeAlso(String seeAlso)
    {
        this.seeAlso = seeAlso;
        return this;
    }

    public String getParent()
    {
        return parent;
    }

    public OptionSpec setParent(String parent)
    {
        this.parent = parent;
        return this;
    }

    public String getReturnType()
    {
        return returnType;
    }

    public OptionSpec setReturnType(String returnType)
    {
        this.returnType = returnType;
        return this;
    }

    public String getDescription()
    {
        return description;
    }

    public OptionSpec setDescription(String description)
    {
        this.description = description;
        return this;
    }

    private final String fullname;

    private final String name;

    private final String title;

    private List<String> values;

    @CheckForNull
    private String defaults;

    @CheckForNull
    private String extending;

    @CheckForNull
    private String excluding;

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

}
