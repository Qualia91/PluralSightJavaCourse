package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.strategy;

public class AmexStrategy extends ValidationStrategy {
	@Override
	public boolean isValid(CreditCard creditCard) {
		return passesLuhn(creditCard.getNumber());
	}
}
