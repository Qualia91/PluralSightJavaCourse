package com.nick.wood.plural_sight_java_course.map_filter_reduce_and_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

    }

    private static void streamStuff() {
        // map filter reduce pattern to get average of people over 20
        Person p1 = new Person("A", 18);
        Person p2 = new Person("B", 19);
        Person p3 = new Person("C", 20);
        Person p4 = new Person("D", 21);
        Person p5 = new Person("E", 22);
        Person p6 = new Person("F", 23);

        ArrayList<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));

        // the average reduction is not associative and so if you did a parallel stream you would not get the correct answer
        // this is example of map -> filter -> reduce pattern
        people.stream().map(Person::getAge).filter(integer -> integer > 20).reduce((integer, integer2) -> (integer + integer2)/2).ifPresent(System.out::println);

        // create streams via above and below which are in the interface of Stream
        // an empty stream
        Stream.empty();

        // singleton stream
        Stream.of("one", "two", "three");

        // a constant stream (infinite)
        Stream.generate(() -> "one");

        // a growing stream (infinite)
        Stream.iterate("+", s -> s + "+");

        // Random stream
        ThreadLocalRandom.current().ints();

        // a stream on letters
        IntStream stream = "hello".chars();

        // stream factory
        Stream.Builder<Object> builder = Stream.builder();
        builder.add("a").add("b").accept("C");
        Stream<Object> build = builder.build();
        // when build method is called, add() or accept() on factory will throw an exception

        Stream<String> generate = Stream.generate(() -> "one").limit(10);
        generate.forEach(System.out::println);

        Stream<Integer> iteratorStream = Stream.iterate(0 , s -> s + 1).limit(10);
        iteratorStream.forEach(System.out::println);

        IntStream intStream = ThreadLocalRandom.current().ints().limit(10);
        intStream.forEach(System.out::println);
    }
}
