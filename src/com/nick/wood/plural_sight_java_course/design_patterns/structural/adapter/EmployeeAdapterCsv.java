package com.nick.wood.plural_sight_java_course.design_patterns.structural.adapter;

public class EmployeeAdapterCsv implements Employee {

	private EmployeeCSV instance;

	public EmployeeAdapterCsv(EmployeeCSV employeeFromCsv) {
		this.instance = employeeFromCsv;
	}

	@Override
	public String getId() {
		return String.valueOf(instance.getId());
	}

	@Override
	public String getFirstName() {
		return instance.getFirstName();
	}

	@Override
	public String getSecondName() {
		return instance.getSecondName();
	}

	@Override
	public String getEmail() {
		return instance.getEmail();
	}


	@Override
	public String toString() {
		return "EmployeeDB{" +
				"id='" + instance.getId() + '\'' +
				", firstName='" + instance.getFirstName() + '\'' +
				", secondName='" + instance.getSecondName() + '\'' +
				", email='" + instance.getEmail() + '\'' +
				'}';
	}
}
