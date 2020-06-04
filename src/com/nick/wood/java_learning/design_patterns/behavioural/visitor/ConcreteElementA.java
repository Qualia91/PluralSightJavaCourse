package com.nick.wood.java_learning.design_patterns.behavioural.visitor;

public class ConcreteElementA implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
