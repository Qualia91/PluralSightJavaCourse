package com.nick.wood.plural_sight_java_course.exception_handling.closeable;

public class CloseableResource implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("CloseableResource closed");
	}
}
