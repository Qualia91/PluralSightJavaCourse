package com.nick.wood.plural_sight_java_course.design_patterns.creational.abstract_factory;

public class VisaValidator implements Validator {

	@Override
	public boolean isValid(CreditCard creditCard) {
		return false;
	}
}
