package com.usesoft.highcharts4gwt.model.mock;

import com.usesoft.highcharts4gwt.model.api.Title;

public class TitleMock implements Title {

	private String text;

	public TitleMock() {
	}

	public String text() {
		return text;
	}

	public Title text(String text) {
		this.text = text;
		return this;
	}

}
