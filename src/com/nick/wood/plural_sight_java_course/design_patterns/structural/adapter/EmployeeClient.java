package com.nick.wood.plural_sight_java_course.design_patterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

	public List<Employee> getEmployeeList() {

		List<Employee> employees = new ArrayList<>();

		Employee employeeFromDb = new EmployeeDB("1234", "John", "Wick", "John@Wick.com");

		employees.add(employeeFromDb);

		EmployeeLdap employeeFromLdap = new EmployeeLdap("chewie", "John", "Wick", "John@Wick.com");

		employees.add(new EmployeeAdapterLdap(employeeFromLdap));

		EmployeeCSV employeeFromCsv = new EmployeeCSV("123", "a", "b", "a@b.com");

		employees.add(new EmployeeAdapterCsv(employeeFromCsv));

		return employees;
	}
}
