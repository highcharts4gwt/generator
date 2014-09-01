package com.usesoft.highcharts4gwt.generator.graph;

import javax.annotation.CheckForNull;

public class OptionNode
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

    @CheckForNull
    private String[] values;

    private String fullname;

    @CheckForNull
    private String defaults;

    private String title;

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

    private String name;

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

    @CheckForNull
    private String parent;

    @CheckForNull
    private String returnType;

    @CheckForNull
    private String description;

    public String[] getValues()
    {
        return values;
    }

    public void setValues(String[] values)
    {
        this.values = values;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public String getDefaults()
    {
        return defaults;
    }

    public void setDefaults(String defaults)
    {
        this.defaults = defaults;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getExtending()
    {
        return extending;
    }

    public void setExtending(String extending)
    {
        this.extending = extending;
    }

    public String getExcluding()
    {
        return excluding;
    }

    public void setExcluding(String excluding)
    {
        this.excluding = excluding;
    }

    public boolean isParent()
    {
        return isParent;
    }

    public void setIsParent(boolean isParent)
    {
        this.isParent = isParent;
    }

    public String getSince()
    {
        return since;
    }

    public void setSince(String since)
    {
        this.since = since;
    }

    public String getDemo()
    {
        return demo;
    }

    public void setDemo(String demo)
    {
        this.demo = demo;
    }

    public boolean isDeprecated()
    {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated)
    {
        this.deprecated = deprecated;
    }

    public String getSeeAlso()
    {
        return seeAlso;
    }

    public void setSeeAlso(String seeAlso)
    {
        this.seeAlso = seeAlso;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getParent()
    {
        return parent;
    }

    public void setParent(String parent)
    {
        this.parent = parent;
    }

    public String getReturnType()
    {
        return returnType;
    }

    public void setReturnType(String returnType)
    {
        this.returnType = returnType;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
