package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.command;

public class OnCommand extends Command {

	private Light light;

	public OnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void unExecute() {
		light.off();
	}

}
