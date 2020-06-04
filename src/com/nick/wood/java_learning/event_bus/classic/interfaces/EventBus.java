package com.nick.wood.java_learning.event_bus.classic.interfaces;

import java.util.List;

public interface EventBus {
	// register new subscribers
	void register(Subscribable subscribable);

	// Send the event to interested subscibers
	void dispatch(Event<?> event);

	// get list of all subscribers
	List<Subscribable> getSubscribers();

}
