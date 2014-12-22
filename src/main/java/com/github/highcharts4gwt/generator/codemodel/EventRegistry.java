package com.github.highcharts4gwt.generator.codemodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.sun.codemodel.JClass;

public class EventRegistry
{
    private EventRegistry()
    {
    }

    public Map<String, List<JClass>> getRegistry()
    {
        return registry;
    }

    public void put(String optionFullName, JClass handlerClass)
    {
        List<JClass> list = registry.get(optionFullName);
        if (list == null)
        {
            list = Lists.<JClass> newArrayList();
            registry.put(optionFullName, list);
        }
        list.add(handlerClass);

        registry.put(optionFullName, list);
    }

    public static final EventRegistry INSTANCE = new EventRegistry();

    private final Map<String, List<JClass>> registry = new HashMap<String, List<JClass>>();

}
