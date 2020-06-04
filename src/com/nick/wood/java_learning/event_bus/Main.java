package com.nick.wood.java_learning.event_bus;

import com.nick.wood.java_learning.event_bus.classic.impl.EventBusImpl;
import com.nick.wood.java_learning.event_bus.classic.impl.SubscribableImpl;
import com.nick.wood.java_learning.event_bus.classic.interfaces.Event;
import com.nick.wood.java_learning.event_bus.classic.interfaces.EventBus;
import com.nick.wood.java_learning.event_bus.classic.interfaces.Subscribable;

public class Main {

    public static void main(String[] args) {

        // classic implementation
        EventBus eventBus = new EventBusImpl();

        Subscribable subscribable = new SubscribableImpl();

        Event<String> message1 = () -> "Hello";
        Event<String> message2 = () -> "World";
        Event<Integer> number = () -> 1;

        eventBus.register(subscribable);

        // will print
        eventBus.dispatch(message1);
        // wont print
        eventBus.dispatch(number);
        // will print
        eventBus.dispatch(message2);



    }
}
