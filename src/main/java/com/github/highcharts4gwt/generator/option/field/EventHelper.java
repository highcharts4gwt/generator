package com.github.highcharts4gwt.generator.option.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.option.Option;

public class EventHelper
{
    public static final String HANDLER_SUFFIX = "Handler";
    public static final String EVENT_SUFFIX = "Event";
    public static final String ON_PREFIX = "on";
    public static final String ADD_HANDLER_METHOD_PREFIX = "add";

    private static final Logger logger = LoggerFactory.getLogger(EventHelper.class);

    private EventHelper()
    {
    }

    public static EventType getType(Option option)
    {
        String context = option.getContext();
        if (context == null)
            logger.error("Event with null context ?!; option;" + option);
        else
            return EventType.valueOf(context);
        return EventType.DoNotTreat;
    }

    public static String getEventNamePrefix(Option option)
    {
        // plotOptions.gauge.events.afterAnimate
        String fullname = option.getFullname();

        int i = fullname.indexOf(".events");

        // plotOptions.gauge
        String v1 = fullname.substring(0, i);

        // gauge
        int i2 = v1.lastIndexOf(".");
        String v2 = "";
        if (i2 != -1)
        {
            v2 = v1.substring(i2 + 1, v1.length());
            v2 = v2.substring(0, 1).toUpperCase() + v2.substring(1);
        }
        else
        {
            v2 = v1.substring(0, 1).toUpperCase() + v1.substring(1);
        }

        // GaugeClickEvent
        String eventName = v2 + option.getTitle().substring(0, 1).toUpperCase() + option.getTitle().substring(1);
        return eventName;
    }

    public static String paramName(String eventName)
    {
        return eventName.substring(0, 1).toLowerCase() + eventName.substring(1) + EventHelper.EVENT_SUFFIX;
    }

    public static String getRegistryKey(Option option)
    {
        int i1 = option.getFullname().lastIndexOf(".");
        String sub1 = option.getFullname().substring(0, i1);
        // int i2 = sub1.lastIndexOf(".");
        // String sub2 = sub1.substring(0, i2);
        return sub1;
    }

}
