package com.nick.wood.java_learning.event_bus.classic.impl;

import com.nick.wood.java_learning.event_bus.classic.interfaces.Event;
import com.nick.wood.java_learning.event_bus.classic.interfaces.EventBus;
import com.nick.wood.java_learning.event_bus.classic.interfaces.Subscribable;

import java.util.ArrayList;
import java.util.List;

public class EventBusImpl implements EventBus {

	private final ArrayList<Subscribable> subscribables = new ArrayList<>();

	@Override
	public void register(Subscribable subscribable) {
		subscribables.add(subscribable);
	}

	@Override
	public void dispatch(Event<?> event) {
		for (Subscribable subscribable : subscribables) {
			subscribable.handle(event);
		}
	}

	@Override
	public List<Subscribable> getSubscribers() {
		return subscribables;
	}
}
