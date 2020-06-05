package com.nick.wood.java_learning.design_patterns.creational.abstract_factory;

public class AmexFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {

		switch (cardType) {
			case GOLD: {
				return new AmexGoldCreditCard();
			}
			default: {
				return new AmexPlatinumCreditCard();
			}
		}

	}

	@Override
	public Validator getValidator(CardType cardType) {
		switch (cardType) {
			case GOLD: {
				return new AmexGoldValidator();
			}
			default: {
				return new AmexPlatinumValidator();
			}
		}
	}
}
