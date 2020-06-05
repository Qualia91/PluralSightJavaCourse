package com.nick.wood.java_learning.design_patterns.structural.decorator;

public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}

	@Override
	public String function() {
		return super.function() + thisFunction();
	}

	private String thisFunction() {
		return "Concrete Decorator A extra functionality - ";
	}
}
