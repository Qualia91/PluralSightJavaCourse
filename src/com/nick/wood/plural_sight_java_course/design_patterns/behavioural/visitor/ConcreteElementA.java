package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.visitor;

public class ConcreteElementA implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
