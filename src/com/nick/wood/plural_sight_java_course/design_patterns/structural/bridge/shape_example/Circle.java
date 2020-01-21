package com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.shape_example;

public class Circle extends Shape {

	public Circle(Colour colour) {
		super(colour);
	}

	@Override
	public void applyColour() {
		super.colour.applyColour();
	}
}
