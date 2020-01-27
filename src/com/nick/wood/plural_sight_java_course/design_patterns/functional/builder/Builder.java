package com.nick.wood.plural_sight_java_course.design_patterns.functional.builder;

import com.nick.wood.plural_sight_java_course.design_patterns.functional.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
