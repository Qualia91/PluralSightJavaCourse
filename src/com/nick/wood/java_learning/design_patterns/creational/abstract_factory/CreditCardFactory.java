package com.nick.wood.java_learning.design_patterns.creational.abstract_factory;

// abstract factory
public abstract class CreditCardFactory {

	public static CreditCardFactory getCreditCardFactory(int creditScore) {

		if (creditScore > 650) {

			return new AmexFactory();

		} else {

			return new VisaFactory();

		}

	}

	public abstract CreditCard getCreditCard(CardType cardType);

	public abstract Validator getValidator(CardType cardType);
}
