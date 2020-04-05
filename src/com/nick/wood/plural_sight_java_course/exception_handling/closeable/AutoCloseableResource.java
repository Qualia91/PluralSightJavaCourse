package com.nick.wood.plural_sight_java_course.exception_handling.closeable;

public class AutoCloseableResource implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("AutoCloseableResource closed");
	}
}
