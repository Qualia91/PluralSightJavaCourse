package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.command;

public class OffCommand extends Command {

	private Light light;

	public OffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void unExecute() {
		light.on();
	}

}
