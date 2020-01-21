package com.nick.wood.plural_sight_java_course.design_patterns.structural.facade;

public class Address {

	private String id;
	private String streetName;
	private String city;

	public Address(String id, String streetName, String city) {
		this.id = id;
		this.streetName = streetName;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id='" + id + '\'' +
				", streetName='" + streetName + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}