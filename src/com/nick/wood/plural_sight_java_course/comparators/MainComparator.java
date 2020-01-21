package com.nick.wood.plural_sight_java_course.comparators;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainComparator {

	public static void main(String[] args) {

		// old way of doing it
		Comparator<Person> ageComparator = (p1, p2) -> p2.getAge() - p1.getAge();
		Comparator<Person> firstNameComparator = (p1, p2) -> p2.getFirstName().compareTo(p1.getFirstName());
		Comparator<Person> secondNameComparator = (p1, p2) -> p2.getSecondName().compareTo(p1.getSecondName());

		// new way:
		// now you can pass a function defining how to get the information you want to compare
		// to a comparing building pattern. You can also pass by it by method reference
		Comparator<Person> ageComparatorNew = Comparator.comparing(Person::getAge);
		Comparator<Person> firstComparatorNew = Comparator.comparing(Person::getFirstName);
		Comparator<Person> secondComparatorNew = Comparator.comparing(Person::getSecondName);

		// combining comparators
		Comparator<Person> comparatorCombi = ageComparatorNew
				.thenComparing(firstComparatorNew)
				.thenComparing(secondComparatorNew);

		// combining comparators all using method references
		Comparator<Person> comparatorCombiScratch = Comparator.comparing(Person::getAge)
				.thenComparing(Person::getFirstName)
				.thenComparing(Person::getSecondName);




	}
}
