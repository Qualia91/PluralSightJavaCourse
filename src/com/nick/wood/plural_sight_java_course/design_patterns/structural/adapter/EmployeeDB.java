package com.nick.wood.plural_sight_java_course.design_patterns.structural.adapter;

public class EmployeeDB implements Employee {

	private String id;
	private String firstName;
	private String secondName;
	private String email;

	public EmployeeDB(String id, String firstName, String secondName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeDB{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", secondName='" + secondName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
