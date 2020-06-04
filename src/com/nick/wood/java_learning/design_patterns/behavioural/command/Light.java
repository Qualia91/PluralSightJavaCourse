package com.nick.wood.java_learning.design_patterns.behavioural.command;

// receiver
public class Light {

	private boolean isOn = false;

	public void toggle() {
		if (isOn) {
			off();
			isOn = false;
		} else {
			on();
			isOn = true;
		}
	}

	public void on() {
		// turn on for debug
		System.out.println("Turn on");
	}

	public void off() {
		// turn on for debug
		System.out.println("Turn off");
	}

}
