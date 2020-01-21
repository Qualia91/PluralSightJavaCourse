package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.state;

public class FanMedState extends State {

	private Fan fan;

	public FanMedState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan onto high");
		fan.setState(fan.getFanHigh());
	}

	@Override
	public String toString() {
		return "Fan is med";
	}
}
