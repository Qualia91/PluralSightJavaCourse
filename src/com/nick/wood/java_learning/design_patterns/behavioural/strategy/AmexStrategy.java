package com.nick.wood.java_learning.design_patterns.behavioural.strategy;

public class AmexStrategy extends ValidationStrategy {
	@Override
	public boolean isValid(CreditCard creditCard) {
		return passesLuhn(creditCard.getNumber());
	}
}
