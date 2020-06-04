package com.nick.wood.java_learning.functional_fsm;

import java.util.ArrayList;

public class Demo {

	private final ConnectionStateManager connectionStateManager;
	private final ArrayList<ConnectionStateChange> connectionStateChanges = new ArrayList<>();

	public Demo() {

		connectionStateManager = new ConnectionStateManager();

		connectionStateManager.getTransitionActionMap().put(
				new ConnectionStateTransition(ConnectionState.NOT_CONNECTED, ConnectionState.CONNECTING),
				() -> connectionStateChanges.add(new ConnectionStateChange(ConnectionState.CONNECTING, ConnectionType.CIGI)));

		connectionStateManager.getTransitionActionMap().put(
				new ConnectionStateTransition(ConnectionState.CONNECTING, ConnectionState.CONNECTED),
				() -> connectionStateChanges.add(new ConnectionStateChange(ConnectionState.CONNECTED, ConnectionType.CIGI)));

		connectionStateManager.getTransitionActionMap().put(
				new ConnectionStateTransition(ConnectionState.CONNECTING, ConnectionState.DISCONNECTING),
				() -> connectionStateChanges.add(new ConnectionStateChange(ConnectionState.DISCONNECTING, ConnectionType.CIGI)));

		connectionStateManager.getTransitionActionMap().put(
				new ConnectionStateTransition(ConnectionState.DISCONNECTING, ConnectionState.NOT_CONNECTED),
				() -> connectionStateChanges.add(new ConnectionStateChange(ConnectionState.NOT_CONNECTED, ConnectionType.CIGI)));

		connectionStateManager.getTransitionActionMap().put(
				new ConnectionStateTransition(ConnectionState.CONNECTING, ConnectionState.NOT_CONNECTED),
				() -> connectionStateChanges.add(new ConnectionStateChange(ConnectionState.NOT_CONNECTED, ConnectionType.CIGI)));

		connectionStateManager.getTransitionActionMap().put(
				new ConnectionStateTransition(ConnectionState.CONNECTED, ConnectionState.NOT_CONNECTED),
				() -> connectionStateChanges.add(new ConnectionStateChange(ConnectionState.NOT_CONNECTED, ConnectionType.CIGI)));

		connectionStateManager.getTransitionActionMap().put(
				new ConnectionStateTransition(ConnectionState.DISCONNECTING, ConnectionState.NOT_CONNECTED),
				() -> connectionStateChanges.add(new ConnectionStateChange(ConnectionState.NOT_CONNECTED, ConnectionType.CIGI)));

	}

	public void transitionTo(ConnectionState connectionState) {
		connectionStateManager.transitionTo(connectionState);
	}

	public ArrayList<ConnectionStateChange> getConnectionStateChanges() {
		return connectionStateChanges;
	}
}
