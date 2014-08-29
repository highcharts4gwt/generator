package com.usesoft.highcharts4gwt.model.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.api.Title;

/** The JSO implementation of Person. */
public class TitleJso extends JavaScriptObject implements Title {
	protected TitleJso() {
	}

	public static native TitleJso create(String text) /*-{
		return {
			text : text
		};
	}-*/;

	public final native String getText() /*-{
		return this.text;
	}-*/;
}