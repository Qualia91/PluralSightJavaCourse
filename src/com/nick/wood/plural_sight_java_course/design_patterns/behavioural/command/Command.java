package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.command;

import com.nick.wood.plural_sight_java_course.design_patterns.creational.prototype.Cloneable;

public abstract class Command implements Cloneable<Command> {

	abstract public void execute();
	abstract public void unExecute();

	@Override
	public Command clone() throws CloneNotSupportedException {
		return (Command) super.clone();
	}

}
