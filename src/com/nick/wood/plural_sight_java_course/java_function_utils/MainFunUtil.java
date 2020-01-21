package com.nick.wood.plural_sight_java_course.java_function_utils;

import java.util.function.*;

public class MainFunUtil {

	public static void main(String[] args) {

		// Consumers: Takes parameter and doesnt return anything
		Consumer<String> consumer = System.out::println;
		BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s2);

		// Supplier: doesnt take parameter and returns object
		Supplier<Integer> supplier = () -> 1;

		// Function: takes object and returns another object. Unary are extensions that take and output same type objects
		Function<Integer, String> function = Object::toString;
		BiFunction<Integer, Integer, String> biFunction = (i1, i2) -> i1.toString() + i2.toString();
		UnaryOperator<Integer> unaryFunction = i -> i + 1;
		BinaryOperator<Integer> binaryFunction = (i1, i2) -> i1 + i2; // which can be replaced by method reference of Integer::sum

		// Predicates: takes object and returns boolean
		Predicate<Integer> predicate = i -> i < 0;

	}
}
