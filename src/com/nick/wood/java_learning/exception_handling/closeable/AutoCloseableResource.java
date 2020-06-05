package com.nick.wood.java_learning.exception_handling.closeable;

public class AutoCloseableResource implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("AutoCloseableResource closed");
	}
}
