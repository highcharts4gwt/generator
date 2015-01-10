package com.github.highcharts4gwt.generator.common;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public abstract class ObjectOrOption implements HasReturnType, HasTitle, IsParent
{
    public abstract String getFullname();

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (obj instanceof ObjectOrOption)
            return Objects.equal(getFullname(), ((ObjectOrOption) obj).getFullname());
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(getFullname());
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("fullName", getFullname()).toString();
    }
}
