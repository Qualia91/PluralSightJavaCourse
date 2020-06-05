package com.nick.wood.java_learning.design_patterns.behavioural.command;

import java.util.Stack;

// invoker
public class Switch {

	Stack<Command> commandStack = new Stack<>();

	public void execute(Command command) {
		command.execute();
		commandStack.push(command);
	}

	public void undo() {
		if ((!commandStack.isEmpty())) {
			commandStack.pop().unExecute();
		} else {
			System.out.println("Undo stack is empty");
		}
	}
}
