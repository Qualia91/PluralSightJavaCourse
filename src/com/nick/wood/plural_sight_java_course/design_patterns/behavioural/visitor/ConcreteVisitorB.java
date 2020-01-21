package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.visitor;

public class ConcreteVisitorB implements Visitor {

	double saveData = 0;

	@Override
	public void visit(ConcreteElementA concreteElementA) {
		saveData += 20;
	}

	@Override
	public void visit(ConcreteElementB concreteElementB) {
		saveData += 1;
	}

	@Override
	public void visit(ConcreteElementC concreteElementC) {
		saveData += 30;
	}

	@Override
	public void visit(ConcreteElementOverall concreteElementOverall) {
		saveData += saveData * saveData;
		System.out.println("Final amount = " + saveData);
	}
}
