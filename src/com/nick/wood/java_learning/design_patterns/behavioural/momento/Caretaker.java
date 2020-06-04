package com.nick.wood.java_learning.design_patterns.behavioural.momento;

import java.util.Stack;

public class Caretaker {

	private final Stack<Memento> history = new Stack<>();

	public void save(Employee employee) {
		history.push(employee.save());
	}

	public void revert(Employee employee) {
		employee.revert(history.pop());
	}
}
