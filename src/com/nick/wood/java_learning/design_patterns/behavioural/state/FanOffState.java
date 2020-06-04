package com.nick.wood.java_learning.design_patterns.behavioural.state;

public class FanOffState extends State {

	private Fan fan;

	public FanOffState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan onto low");
		fan.setState(fan.getFanLow());
	}

	@Override
	public String toString() {
		return "Fan is off";
	}
}
