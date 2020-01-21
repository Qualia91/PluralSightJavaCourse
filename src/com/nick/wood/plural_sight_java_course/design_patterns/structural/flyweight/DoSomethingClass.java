package com.nick.wood.plural_sight_java_course.design_patterns.structural.flyweight;

// nothing to do with flyweight pattern
public class DoSomethingClass {

	private final int number;
	private final ConcreteFlyweight concreteFlyweight;

	public DoSomethingClass(int number, ConcreteFlyweight concreteFlyweight) {
		this.number = number;
		this.concreteFlyweight = concreteFlyweight;
	}

	void doIt() {
		System.out.println(concreteFlyweight.doSomething() + " " + number);
	}
}
