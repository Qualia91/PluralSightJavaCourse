package com.nick.wood.plural_sight_java_course.design_patterns.structural.adapter;

public class EmployeeAdapterLdap implements Employee {

	private EmployeeLdap instance;

	public EmployeeAdapterLdap(EmployeeLdap employeeFromLdap) {
		this.instance = employeeFromLdap;
	}

	@Override
	public String getId() {
		return instance.getCn();
	}

	@Override
	public String getFirstName() {
		return instance.getGivenName();
	}

	@Override
	public String getSecondName() {
		return instance.getSurname();
	}

	@Override
	public String getEmail() {
		return instance.getMail();
	}

	@Override
	public String toString() {
		return "EmployeeDB{" +
				"id='" + instance.getCn() + '\'' +
				", firstName='" + instance.getGivenName() + '\'' +
				", secondName='" + instance.getSurname() + '\'' +
				", email='" + instance.getMail() + '\'' +
				'}';
	}
}
