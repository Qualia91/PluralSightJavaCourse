package com.nick.wood.java_learning.design_patterns.behavioural.mediator;

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
