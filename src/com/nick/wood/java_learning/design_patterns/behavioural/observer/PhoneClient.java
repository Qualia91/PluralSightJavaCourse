package com.nick.wood.java_learning.design_patterns.behavioural.observer;

public class PhoneClient extends ObserverPlus {

	public PhoneClient(Subject subject) {
		super.subject = subject;
		subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Phone client: " + subject.getState());
	}

	public void addMessage(String message) {
		subject.setState(message + " - sent from phone");
	}
}
