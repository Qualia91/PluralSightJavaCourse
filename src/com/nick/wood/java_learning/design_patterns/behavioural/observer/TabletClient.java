package com.nick.wood.java_learning.design_patterns.behavioural.observer;

public class TabletClient extends ObserverPlus {

	public TabletClient(Subject subject) {
		super.subject = subject;
		subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Tablet client: " + subject.getState());
	}

	public void addMessage(String message) {
		subject.setState(message + " - sent from tablet");
	}

}
