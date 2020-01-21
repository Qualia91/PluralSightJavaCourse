package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.visitor;

import java.util.ArrayList;

public class ConcreteElementOverall implements Element {

	private final ArrayList<Element> elements = new ArrayList<>();

	public ArrayList<Element> getElements() {
		return elements;
	}

	@Override
	public void accept(Visitor visitor) {

		for (Element element : elements) {
			element.accept(visitor);
		}

		visitor.visit(this);
	}

}
