package com.nick.wood.java_learning.design_patterns.functional.builder;

import com.nick.wood.java_learning.design_patterns.functional.factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public interface Registry {

    Factory<? extends Shape> buildShapeFactory(String shape);

    static Registry createRegistry(Consumer<Builder<Shape>> consumer) {

        Map<String, Factory<Shape>> map = new HashMap<>();

        Builder<Shape> builder = (map::put);

        consumer.accept(builder);

        return shape -> map.getOrDefault(shape, () -> { throw new IllegalArgumentException("Not a valid type");});

    }
}
