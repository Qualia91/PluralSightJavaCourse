package com.nick.wood.java_learning.design_patterns.structural.bridge.shape_example;

public class Square extends Shape {

	public Square(Colour colour) {
		super(colour);
	}

	@Override
	public void applyColour() {
		super.colour.applyColour();
	}
}
