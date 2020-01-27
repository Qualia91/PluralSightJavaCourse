package com.nick.wood.plural_sight_java_course.design_patterns.functional;

import com.nick.wood.plural_sight_java_course.design_patterns.functional.builder.*;
import com.nick.wood.plural_sight_java_course.design_patterns.functional.factory.Circle;
import com.nick.wood.plural_sight_java_course.design_patterns.functional.factory.Factory;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        // factory
        Factory<Circle> factory = Circle::new;

        Circle circle1 = factory.newInstance();

        System.out.println(circle1);

        List<Circle> circles = factory.create5();

        System.out.println(circles.get(4));

        // factory of factories
        Factory<Circle> factoryOfFactories = Factory.createFactory(() -> new Circle(1));

        Circle circle = factoryOfFactories.newInstance();

        System.out.println(circle);

        Factory<Circle> factoryOfFactoriesConstructor = Factory.createFactory(Circle::new, 2);

        Circle circle2 = factoryOfFactoriesConstructor.newInstance();

        System.out.println(circle2);


        // builder
        Consumer<Builder<Shape>> squareConsumer = builder -> builder.register("square", Square::new);
        Consumer<Builder<Shape>> triangleConsumer = builder -> builder.register("triangle", Triangle::new);

        Consumer<Builder<Shape>> builderConsumer = squareConsumer.andThen(triangleConsumer);

        Registry registry = Registry.createRegistry(builderConsumer);

        Factory<Square> squareFactory = (Factory<Square>) registry.buildShapeFactory("square");
        Factory<Triangle> triangleFactory = (Factory<Triangle>) registry.buildShapeFactory("triangle");

        System.out.println(squareFactory.newInstance());
        System.out.println(triangleFactory.newInstance());


    }
}
