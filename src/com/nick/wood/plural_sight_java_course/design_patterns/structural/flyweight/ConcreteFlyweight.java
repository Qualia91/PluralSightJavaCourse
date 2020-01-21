package com.nick.wood.plural_sight_java_course.design_patterns.structural.flyweight;

public class ConcreteFlyweight implements FlyweightInterface{

	// data is final and immutable
	private final String data;

	public ConcreteFlyweight(String data) {
		this.data = data;
	}

	@Override
	public String doSomething() {
		return data;
	}
}
