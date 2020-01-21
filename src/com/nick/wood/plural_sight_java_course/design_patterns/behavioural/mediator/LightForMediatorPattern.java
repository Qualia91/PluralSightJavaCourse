package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator;

// receiver
public class LightForMediatorPattern {

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

	public boolean isOn() {
		return isOn;
	}
}
