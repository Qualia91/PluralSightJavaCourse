package com.nick.wood.java_learning.reflection_api;

import com.nick.wood.java_learning.reflection_api.annotations.Column;
import com.nick.wood.java_learning.reflection_api.annotations.PrimaryKey;

/** class with metadata added with annotations
 *
 */
public class Person {

	@PrimaryKey
	private long id;
	@Column
	private int age;
	@Column
	private String name;

	public Person(long id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}
