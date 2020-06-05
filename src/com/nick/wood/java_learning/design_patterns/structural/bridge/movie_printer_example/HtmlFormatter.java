package com.nick.wood.java_learning.design_patterns.structural.bridge.movie_printer_example;

import java.util.List;

public class HtmlFormatter implements Formatter {
	@Override
	public String format(String header, List<Detail> details) {
		StringBuilderPlus stringBuilder = new StringBuilderPlus();

		stringBuilder.appendLine("<table>")
				.appendLine("<th>")
				.appendLine("Classification")
				.appendLine("</th>")
				.appendLine("<th>")
				.appendLine(header)
				.appendLine("</th>");


		for (Detail detail : details) {
			stringBuilder.appendLine("<tr><td>")
					.appendLine(detail.getLabel())
					.appendLine("</td><td>")
					.appendLine(detail.getValue())
					.appendLine("</td></tr>");
		}

		stringBuilder.appendLine("</table>");

		return stringBuilder.toString();
	}
}
