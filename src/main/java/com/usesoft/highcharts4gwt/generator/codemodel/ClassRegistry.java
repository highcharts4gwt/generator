package com.usesoft.highcharts4gwt.generator.codemodel;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.sun.codemodel.JClass;
import com.usesoft.highcharts4gwt.generator.graph.Option;

public class ClassRegistry
{
    private ClassRegistry()
    {
    }

    public Map<RegistryKey, JClass> getRegistry()
    {
        return registry;
    }

    public void put(Option optionSpec, OutputType type, JClass jClass)
    {
        registry.put(new RegistryKey(optionSpec, type), jClass);
    }

    public static final ClassRegistry INSTANCE = new ClassRegistry();

    private final Map<RegistryKey, JClass> registry = new HashMap<RegistryKey, JClass>();

    public static class RegistryKey
    {
        private final Option optionSpec;
        private final OutputType type;

        public RegistryKey(Option optionSpec, OutputType type)
        {
            this.optionSpec = optionSpec;
            this.type = type;
        }

        public Option getOptionSpec()
        {
            return optionSpec;
        }

        public OutputType getType()
        {
            return type;
        }

        @Override
        public String toString()
        {
            return MoreObjects.toStringHelper(this).add("optionSpec", optionSpec).add("type", type).toString();
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj == this)
                return true;
            if (obj instanceof RegistryKey)
                return Objects.equal(optionSpec, ((RegistryKey) obj).optionSpec) && Objects.equal(type, ((RegistryKey) obj).type);
            return false;
        }

        @Override
        public int hashCode()
        {
            return Objects.hashCode(optionSpec, type);
        }

    }
}
