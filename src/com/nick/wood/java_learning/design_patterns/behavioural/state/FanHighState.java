package com.nick.wood.java_learning.design_patterns.behavioural.state;

public class FanHighState extends State {

	private Fan fan;

	public FanHighState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan off");
		fan.setState(fan.getFanOff());
	}

	@Override
	public String toString() {
		return "Fan is high";
	}
}
