package com.nick.wood.java_learning.design_patterns.behavioural.visitor;

public interface Visitor {
	public void visit(ConcreteElementA concreteElementA);
	public void visit(ConcreteElementB concreteElementB);
	public void visit(ConcreteElementC concreteElementC);
	public void visit(ConcreteElementOverall concreteElementOverall);
}
