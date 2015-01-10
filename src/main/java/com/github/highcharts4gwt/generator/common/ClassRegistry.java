package com.github.highcharts4gwt.generator.common;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.sun.codemodel.JClass;

public class ClassRegistry
{
    private ClassRegistry()
    {
    }

    public Map<RegistryKey, JClass> getRegistry()
    {
        return registry;
    }

    public void put(ObjectOrOption hasFullname, OutputType type, JClass jClass)
    {
        registry.put(new RegistryKey(hasFullname, type), jClass);
    }

    public static final ClassRegistry INSTANCE = new ClassRegistry();

    private final Map<RegistryKey, JClass> registry = new HashMap<RegistryKey, JClass>();

    public static class RegistryKey
    {
        private final ObjectOrOption hasFullname;
        private final OutputType type;

        public RegistryKey(ObjectOrOption hasFullname, OutputType type)
        {
            this.hasFullname = hasFullname;
            this.type = type;
        }

        @Override
        public String toString()
        {
            return MoreObjects.toStringHelper(this).add("option/object", hasFullname).add("type", type).toString();
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj == this)
                return true;
            if (obj instanceof RegistryKey)
                return Objects.equal(hasFullname, ((RegistryKey) obj).hasFullname) && Objects.equal(type, ((RegistryKey) obj).type);
            return false;
        }

        @Override
        public int hashCode()
        {
            return Objects.hashCode(hasFullname, type);
        }

    }
}
