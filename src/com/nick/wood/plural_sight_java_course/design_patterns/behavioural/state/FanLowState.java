package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.state;

public class FanLowState extends State {

	private Fan fan;

	public FanLowState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan onto med");
		fan.setState(fan.getFanMed());
	}

	@Override
	public String toString() {
		return "Fan is low";
	}
}
