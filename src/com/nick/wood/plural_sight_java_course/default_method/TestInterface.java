package com.nick.wood.plural_sight_java_course.default_method;

public interface TestInterface {

	// abstract method
	public void square(int a);

	// default method
	default void show()
	{
		System.out.println("Default Method Executed");
	}

}
