package com.nick.wood.java_learning.design_patterns.structural.adapter;

public class EmployeeCSV {

	private int id;
	private String firstName;
	private String secondName;
	private String email;

	public EmployeeCSV(String id, String firstName, String secondName, String email) {
		this.id = Integer.parseInt(id);
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
