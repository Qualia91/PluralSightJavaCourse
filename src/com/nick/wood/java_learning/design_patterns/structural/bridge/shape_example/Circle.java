package com.nick.wood.java_learning.design_patterns.structural.bridge.shape_example;

public class Circle extends Shape {

	public Circle(Colour colour) {
		super(colour);
	}

	@Override
	public void applyColour() {
		super.colour.applyColour();
	}
}
