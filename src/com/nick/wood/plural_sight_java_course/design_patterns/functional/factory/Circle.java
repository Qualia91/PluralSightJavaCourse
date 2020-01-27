package com.nick.wood.plural_sight_java_course.design_patterns.functional.factory;

public class Circle {
    private final int i;

    public Circle(int i) {
        this.i = i;
    }
    public Circle() {
        this.i = 0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "i=" + i +
                '}';
    }
}
