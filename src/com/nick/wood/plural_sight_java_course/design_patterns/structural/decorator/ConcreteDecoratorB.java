package com.nick.wood.plural_sight_java_course.design_patterns.structural.decorator;

public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	@Override
	public String function() {
		return super.function() + thisFunction();
	}

	private String thisFunction() {
		return "Concrete Decorator B extra functionality - ";
	}
}
