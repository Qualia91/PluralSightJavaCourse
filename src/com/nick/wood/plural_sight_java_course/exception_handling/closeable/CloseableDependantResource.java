package com.nick.wood.plural_sight_java_course.exception_handling.closeable;

public class CloseableDependantResource implements AutoCloseable {

	public CloseableDependantResource(CloseableResource closeableResource) {
	}

	@Override
	public void close() throws Exception {
		System.out.println("CloseableDependantResource closed");
	}
}
