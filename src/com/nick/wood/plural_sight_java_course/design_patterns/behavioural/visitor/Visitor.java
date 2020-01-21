package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.visitor;

public interface Visitor {
	public void visit(ConcreteElementA concreteElementA);
	public void visit(ConcreteElementB concreteElementB);
	public void visit(ConcreteElementC concreteElementC);
	public void visit(ConcreteElementOverall concreteElementOverall);
}
