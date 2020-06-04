package com.nick.wood.java_learning.functional_fsm;

import java.util.HashMap;

public class ConnectionStateManager {

	private ConnectionState currentConnectionState = ConnectionState.NOT_CONNECTED;
	private HashMap<ConnectionStateTransition, Runnable> transitionActionMap = new HashMap<>();

	public ConnectionStateManager() {
	}

	public void transitionTo(ConnectionState connectionState) {
		ConnectionStateTransition connectionStateTransition = new ConnectionStateTransition(currentConnectionState, connectionState);
		if (transitionActionMap.containsKey(connectionStateTransition)) {
			transitionActionMap.get(connectionStateTransition).run();
			currentConnectionState = connectionState;
		}
	}

	public HashMap<ConnectionStateTransition, Runnable> getTransitionActionMap() {
		return transitionActionMap;
	}

	public ConnectionState getCurrentConnectionState() {
		return currentConnectionState;
	}
}
