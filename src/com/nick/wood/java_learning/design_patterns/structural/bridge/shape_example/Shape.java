package com.nick.wood.java_learning.design_patterns.structural.bridge.shape_example;

public abstract class Shape {

	protected Colour colour;

	public Shape(Colour colour) {
		this.colour = colour;
	}

	abstract public void applyColour();

}
