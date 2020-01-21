package com.nick.wood.plural_sight_java_course.design_patterns.structural.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StateCreator {

	private final FlyweightFactory flyweightFactory = new FlyweightFactory();
	private final List<DoSomethingClass> doSomethingClasses = new CopyOnWriteArrayList<>();

	public void createDoSomethingClass(String name, int number) {
		ConcreteFlyweight concreteFlyweight = flyweightFactory.lookup(name);
		DoSomethingClass doSomethingClass = new DoSomethingClass(number, concreteFlyweight);
		doSomethingClasses.add(doSomethingClass);
	}

	public void process() {
		for (DoSomethingClass doSomethingClass : doSomethingClasses) {
			doSomethingClass.doIt();
			doSomethingClasses.remove(doSomethingClass);
		}
	}

	public String report() {
		return String.valueOf(flyweightFactory.getMapSize());
	}

}
