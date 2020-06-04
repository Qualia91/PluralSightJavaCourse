package com.nick.wood.java_learning.exception_handling.closeable;

public class CloseableDependantResource implements AutoCloseable {

	public CloseableDependantResource(CloseableResource closeableResource) {
	}

	@Override
	public void close() throws Exception {
		System.out.println("CloseableDependantResource closed");
	}
}
