package com.nick.wood.java_learning.functional_fsm;

import java.util.Objects;

public class ConnectionStateTransition {

	private final ConnectionState connectionStateOne;
	private final ConnectionState connectionStateTwo;

	public ConnectionStateTransition(ConnectionState connectionStateOne, ConnectionState connectionStateTwo) {
		this.connectionStateOne = connectionStateOne;
		this.connectionStateTwo = connectionStateTwo;
	}

	public ConnectionState getConnectionStateOne() {
		return connectionStateOne;
	}

	public ConnectionState getConnectionStateTwo() {
		return connectionStateTwo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConnectionStateTransition that = (ConnectionStateTransition) o;
		return connectionStateOne == that.connectionStateOne &&
				connectionStateTwo == that.connectionStateTwo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(connectionStateOne, connectionStateTwo);
	}
}
