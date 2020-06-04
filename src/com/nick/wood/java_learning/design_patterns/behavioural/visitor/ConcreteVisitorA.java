package com.nick.wood.java_learning.design_patterns.behavioural.visitor;

public class ConcreteVisitorA implements Visitor {

	double saveData = 0;

	@Override
	public void visit(ConcreteElementA concreteElementA) {
		saveData += 10;
	}

	@Override
	public void visit(ConcreteElementB concreteElementB) {
		saveData += 20;
	}

	@Override
	public void visit(ConcreteElementC concreteElementC) {
		saveData += 30;
	}

	@Override
	public void visit(ConcreteElementOverall concreteElementOverall) {
		System.out.println("Can also use info aor original class " + concreteElementOverall.getElements().size());
		saveData += 40;
		System.out.println("Final amount = " + saveData);
	}
}
