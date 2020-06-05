package com.nick.wood.java_learning.design_patterns.structural.bridge.movie_printer_example;

public class StringBuilderPlus {

	private final StringBuilder stringBuilder;

	public StringBuilderPlus() {
		this.stringBuilder = new StringBuilder();
	}

	public <T> StringBuilderPlus append(T t) {
		stringBuilder.append(t);
		return this;
	}

	public <T> StringBuilderPlus appendLine(T t) {
		stringBuilder.append(t).append(System.lineSeparator());
		return this;
	}

	@Override
	public String toString() {
		return stringBuilder.toString();
	}

	public StringBuilder getStringBuilder() {
		return stringBuilder;
	}
}