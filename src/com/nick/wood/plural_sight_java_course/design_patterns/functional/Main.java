package com.nick.wood.plural_sight_java_course.design_patterns.functional;

import com.nick.wood.plural_sight_java_course.design_patterns.functional.validator.Person;
import com.nick.wood.plural_sight_java_course.design_patterns.functional.validator.Validator;
import com.nick.wood.plural_sight_java_course.design_patterns.functional.visitor.*;

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


    }
}
