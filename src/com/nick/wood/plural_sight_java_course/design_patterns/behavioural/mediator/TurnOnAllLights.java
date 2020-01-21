package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator;

public class TurnOnAllLights implements Command {

	private Mediator mediator;

	public TurnOnAllLights(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void execute() {
		mediator.turnOnAllLights();
	}
}
