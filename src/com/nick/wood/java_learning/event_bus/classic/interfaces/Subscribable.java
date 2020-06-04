package com.nick.wood.java_learning.event_bus.classic.interfaces;

import java.util.Set;

public interface Subscribable {
	// consumes the events dispatched by the bus
	void handle(Event<?> event);

	// Describes the set of classes the subscribable object intends to handle
	Set<Class<?>> supports();
}
