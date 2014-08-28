package com.usesoft.gwthighcharts.model.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.gwthighcharts.model.api.Title;

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