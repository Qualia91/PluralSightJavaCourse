package com.nick.wood.java_learning.design_patterns.functional.factory;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    // pass the factory
    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        return supplier::get;
    }

    // singleton version: below always produces same object
    static <T> Factory<T> createFactorySingleton(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    // pass the constructor and a value
    static <T, U> Factory<T> createFactory(Function<U, T> constructor, U value) {
        return () -> constructor.apply(value);
    }

    default T newInstance() {
        return get();
    }

    default List<T> create5() {

        return IntStream.range(0, 5)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());

    }
}
