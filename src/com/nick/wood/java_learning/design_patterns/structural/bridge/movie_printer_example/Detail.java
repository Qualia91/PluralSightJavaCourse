package com.nick.wood.java_learning.design_patterns.structural.bridge.movie_printer_example;

public class Detail {

	private String label;
	private String value;

	public Detail(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
