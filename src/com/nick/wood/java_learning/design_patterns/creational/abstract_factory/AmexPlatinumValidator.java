package com.nick.wood.java_learning.design_patterns.creational.abstract_factory;

public class AmexPlatinumValidator implements Validator {

	@Override
	public boolean isValid(CreditCard creditCard) {
		return false;
	}

}
