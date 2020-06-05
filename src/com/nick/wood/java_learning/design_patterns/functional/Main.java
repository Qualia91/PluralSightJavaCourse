package com.nick.wood.java_learning.design_patterns.functional;

import com.nick.wood.java_learning.design_patterns.functional.validator.Person;
import com.nick.wood.java_learning.design_patterns.functional.validator.Validator;
import com.nick.wood.java_learning.design_patterns.functional.visitor.*;
import com.nick.wood.java_learning.design_patterns.functional.builder.*;
import com.nick.wood.java_learning.design_patterns.functional.factory.Circle;
import com.nick.wood.java_learning.design_patterns.functional.factory.Factory;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        // visitor
        Car car = new Car();
        Body body = new Body();
        Engine engine = new Engine();

        Consumer<VisitorBuilder<String>> consumer = Visitor
                .<Car, String>forType(Car.class).execute(c -> "Visiting car: " + c)
                .forType(Body.class).execute(c -> "Visiting body: " + c)
                .forType(Engine.class).execute(c -> "Visiting engine: " + c);

        Visitor<String> stringVisitor = Visitor.of(consumer);

        System.out.println(stringVisitor.visit(car));
        System.out.println(stringVisitor.visit(body));
        System.out.println(stringVisitor.visit(engine));



        // validator
        Person p1 = new Person("p1", 1);
        Person p2 = new Person(null, 1);
        Person p3 = new Person("p3", -1);
        Person p4 = new Person("p4", 1_000);
        Person p5 = new Person(null, -1);

        Person validatedPerson = Validator
                .<Person>validate(p -> p.getName() != null, obj -> obj.toString() + "'s name should not be null")
                .thenValidate(p -> p.getAge() > 0, obj -> obj.toString() + "'s age should not be less than 0")
                .thenValidate(p -> p.getAge() < 150, obj -> obj.toString() + "'s age should not be more than 150")
                .on(p5).validate();

        Validator<Person> personValidator = Validator
                .<Person>validate(p -> p.getName() != null, obj -> obj.toString() + "'s name should not be null")
                .thenValidate(p -> p.getAge() > 0, obj -> obj.toString() + "'s age should not be less than 0")
                .thenValidate(p -> p.getAge() < 150, obj -> obj.toString() + "'s age should not be more than 150");


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
