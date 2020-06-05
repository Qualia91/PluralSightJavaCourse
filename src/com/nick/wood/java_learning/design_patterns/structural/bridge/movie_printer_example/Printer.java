package com.nick.wood.java_learning.design_patterns.structural.bridge.movie_printer_example;

import java.util.List;

public abstract class Printer {

	public String print(Formatter formatter) {
		return formatter.format(getHeader(), getDetails());
	}

	protected abstract String getHeader();

	protected abstract List<Detail> getDetails();

}
