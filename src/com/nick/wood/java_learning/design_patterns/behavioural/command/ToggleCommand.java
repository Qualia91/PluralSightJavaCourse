package com.nick.wood.java_learning.design_patterns.behavioural.command;

public class ToggleCommand extends Command {

	private Light light;

	public ToggleCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.toggle();
	}

	@Override
	public void unExecute() {
		light.toggle();
	}
}
