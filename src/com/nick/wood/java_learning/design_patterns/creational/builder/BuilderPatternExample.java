package com.nick.wood.java_learning.design_patterns.creational.builder;

public class BuilderPatternExample {

	public static class Builder {

		private String varOne;
		private String varTwo;
		private String varThree;
		private String varFour;

		public Builder() {
		}

		public BuilderPatternExample build() {
			return new BuilderPatternExample(this);
		}

		public Builder varOne(String varOne) {
			this.varOne = varOne;
			return this;
		}

		public Builder varTwo(String varTwo) {
			this.varTwo = varTwo;
			return this;
		}

		public Builder varThree(String varThree) {
			this.varThree = varThree;
			return this;
		}

		public Builder varFour(String varFour) {
			this.varFour = varFour;
			return this;
		}
	}

	private final String varOne;
	private final String varTwo;
	private final String varThree;
	private final String varFour;

	private BuilderPatternExample(Builder builder) {
		this.varOne = builder.varOne;
		this.varTwo = builder.varTwo;
		this.varThree = builder.varThree;
		this.varFour = builder.varFour;
	}

	public String getVarOne() {
		return varOne;
	}

	public String getVarTwo() {
		return varTwo;
	}

	public String getVarThree() {
		return varThree;
	}

	public String getVarFour() {
		return varFour;
	}
}
