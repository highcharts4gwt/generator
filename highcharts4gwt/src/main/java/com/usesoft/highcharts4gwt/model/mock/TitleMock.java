package com.usesoft.highcharts4gwt.model.mock;

import com.usesoft.highcharts4gwt.model.api.Title;

public class TitleMock implements Title {

	private final String text;

	public TitleMock(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
