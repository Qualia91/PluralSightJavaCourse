package com.nick.wood.java_learning.event_bus.classic.impl;

import com.nick.wood.java_learning.event_bus.classic.interfaces.Event;
import com.nick.wood.java_learning.event_bus.classic.interfaces.Subscribable;

import java.util.HashSet;
import java.util.Set;

public class SubscribableImpl implements Subscribable {

	private final Set<Class<?>> supportedClasses = new HashSet<>();

	public SubscribableImpl() {
		supportedClasses.add(String.class);
	}

	@Override
	public void handle(Event<?> event) {
		if (supportedClasses.contains(event.getData().getClass())) {
			System.out.println(event.getData());
		}
	}

	@Override
	public Set<Class<?>> supports() {
		return supportedClasses;
	}
}
