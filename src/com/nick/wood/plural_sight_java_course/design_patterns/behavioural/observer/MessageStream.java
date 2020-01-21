package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.observer;

import java.util.ArrayDeque;
import java.util.Deque;

// stores a history of the messages
public class MessageStream extends Subject {

	private Deque<String> messageHistory = new ArrayDeque<>();

	@Override
	void setState(String state) {
		messageHistory.add(state);
		this.notifyObservers();
	}

	@Override
	String getState() {
		return messageHistory.getLast();
	}

	public Deque<String> getMessageHistory() {
		return messageHistory;
	}
}
