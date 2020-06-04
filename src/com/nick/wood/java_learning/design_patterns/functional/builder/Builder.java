package com.nick.wood.java_learning.design_patterns.functional.builder;

import com.nick.wood.java_learning.design_patterns.functional.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
