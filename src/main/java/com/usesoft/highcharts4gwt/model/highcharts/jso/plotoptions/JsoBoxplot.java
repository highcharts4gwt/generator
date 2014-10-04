
package com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions;

import com.usesoft.highcharts4gwt.model.highcharts.api.plotoptions.Boxplot;
import com.usesoft.highcharts4gwt.model.highcharts.jso.plotoptions.JsoColumn;

public class JsoBoxplot
    extends JsoColumn
    implements Boxplot
{


    protected JsoBoxplot() {
    }

    public final native Number medianWidth()
        throws RuntimeException /*-{
        return this["medianWidth"] = (this["medianWidth"] || 2.0);
    }-*/
    ;

    public final native JsoBoxplot medianWidth(Number medianWidth)
        throws RuntimeException /*-{
        this["medianWidth"] = medianWidth;
        return this;
    }-*/
    ;

    public final native String stemDashStyle()
        throws RuntimeException /*-{
        return this["stemDashStyle"] = (this["stemDashStyle"] || "Solid");
    }-*/
    ;

    public final native JsoBoxplot stemDashStyle(String stemDashStyle)
        throws RuntimeException /*-{
        this["stemDashStyle"] = stemDashStyle;
        return this;
    }-*/
    ;

    public final native Number stemWidth()
        throws RuntimeException /*-{
        return this["stemWidth"] = (this["stemWidth"] || null);
    }-*/
    ;

    public final native JsoBoxplot stemWidth(Number stemWidth)
        throws RuntimeException /*-{
        this["stemWidth"] = stemWidth;
        return this;
    }-*/
    ;

    public final native Number whiskerWidth()
        throws RuntimeException /*-{
        return this["whiskerWidth"] = (this["whiskerWidth"] || 2.0);
    }-*/
    ;

    public final native JsoBoxplot whiskerWidth(Number whiskerWidth)
        throws RuntimeException /*-{
        this["whiskerWidth"] = whiskerWidth;
        return this;
    }-*/
    ;

}
