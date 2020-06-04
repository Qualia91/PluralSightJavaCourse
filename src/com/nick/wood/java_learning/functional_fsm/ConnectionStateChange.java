package com.nick.wood.java_learning.functional_fsm;

public class ConnectionStateChange {

	private final ConnectionState connectionState;
	private final ConnectionType connectionType;

	public ConnectionStateChange(ConnectionState connectionState, ConnectionType connectionType) {
		this.connectionState = connectionState;
		this.connectionType = connectionType;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public ConnectionState getData() {
		return connectionState;
	}
}
