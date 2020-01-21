package com.nick.wood.plural_sight_java_course.design_patterns.structural.decorator;

public abstract class Decorator implements Component {

	// protected so anyone who subs this class can use it
	protected Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public String function() {
		return this.component.function();
	}
}
