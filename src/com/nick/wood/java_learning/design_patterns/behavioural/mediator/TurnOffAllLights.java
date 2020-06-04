package com.nick.wood.java_learning.design_patterns.behavioural.mediator;

public class TurnOffAllLights implements Command {
	private Mediator mediator;

	public TurnOffAllLights(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void execute() {
		mediator.turnOffAllLights();
	}
}
