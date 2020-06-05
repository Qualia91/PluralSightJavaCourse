package com.nick.wood.java_learning.design_patterns.structural.bridge.movie_printer_example;

import java.util.List;

public class PrintFormatter implements Formatter {
	@Override
	public String format(String header, List<Detail> details) {
		StringBuilderPlus stringBuilder = new StringBuilderPlus();
		stringBuilder.append(header).append("\n");

		for (Detail detail : details) {
			stringBuilder.append(detail.getLabel()).append(": ").append(detail.getValue()).append("\n");
		}

		return stringBuilder.toString();
	}
}
