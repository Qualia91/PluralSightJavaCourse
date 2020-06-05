package com.nick.wood.java_learning.design_patterns.structural.flyweight;

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
