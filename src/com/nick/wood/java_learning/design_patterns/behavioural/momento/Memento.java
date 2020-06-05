package com.nick.wood.java_learning.design_patterns.behavioural.momento;

public class Memento {

	private final String name;
	private final String phoneNumber;

	public Memento(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
