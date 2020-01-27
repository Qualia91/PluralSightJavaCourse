package com.nick.wood.plural_sight_java_course.design_patterns.functional.visitor;

import java.util.function.Function;

public interface VisitorBuilder<R> {
	<T> void register(Class<T> type, Function<T, R> function);
}
