package com.nick.wood.java_learning.iterable_and_collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    private static void mapStuff() {

        Person p1 = new Person("A", 1);
        Person p2 = new Person("B", 2);
        Person p3 = new Person("C", 3);
        Person p4 = new Person("D", 4);
        Person p5 = new Person("E", 5);
        Person p6 = new Person("F", 6);

        City c1 = new City("Q");
        City c2 = new City("W");
        City c3 = new City("E");

        Map<City, List<Person>> map1 = new HashMap<>();
        // using compute if absent too add values to list in map
        // computeIfAbsent returns value so can use add after the function
        map1.computeIfAbsent(c1, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(c2, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(c2, city -> new ArrayList<>()).add(p3);

        Map<City, List<Person>> map2 = new HashMap<>();
        // using compute if absent too add values to list in map
        // computeIfAbsent returns value so can use add after the function
        map2.computeIfAbsent(c2, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(c3, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(c3, city -> new ArrayList<>()).add(p6);

        System.out.println("map 1");
        map1.forEach((city, people) -> System.out.println(city.toString() + people.toString()));

        System.out.println("map 2");
        map2.forEach((city, people) -> System.out.println(city.toString() + people.toString()));

        // merging
        map2.forEach((city, people) -> {
            map1.merge(city, people, (people1, people2) -> {
                people1.addAll(people2);
                return people1;
            });
        });

        System.out.println("map 1 after merge");
        map1.forEach((city, people) -> System.out.println(city.toString() + people.toString()));

    }

    private static void listStuff() {

        Person p1 = new Person("A", 1);
        Person p2 = new Person("B", 2);
        Person p3 = new Person("C", 3);
        Person p4 = new Person("D", 4);
        Person p5 = new Person("E", 5);
        Person p6 = new Person("F", 6);

        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));

        people.removeIf(person -> person.getAge() < 4);

        people.replaceAll(person -> new Person(person.getName().toLowerCase(), person.getAge()));

        people.sort(Comparator.comparing(Person::getAge).reversed());

        people.forEach(System.out::println);

    }

    private static void merging() {
        Map<String, List<Integer>> map1 = new HashMap<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(3);
        map1.put("Hello", array1);

        Map<String, List<Integer>> map2 = new HashMap<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(2);
        map2.put("Hello", array2);

        map2.forEach(
                (s, integers) -> {
                    map1.merge(s, integers, (map1Integers, map2Integers) -> {
                        System.out.println();
                        map1Integers.addAll(map2Integers);
                        return map1Integers;
                    });
                }
        );
    }
}
