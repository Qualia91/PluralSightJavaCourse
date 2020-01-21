package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.strategy;

public class CreditCard {

	private String number;
	private String date;
	private String cvv;
	private ValidationStrategy validationStrategy;

	public CreditCard(ValidationStrategy validationStrategy) {
		this.validationStrategy = validationStrategy;
	}

	public boolean isValid() {
		return validationStrategy.isValid(this);
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNumber() {
		return number;
	}

	public String getDate() {
		return date;
	}

	public String getCvv() {
		return cvv;
	}
}
