package com.nick.wood.java_learning.design_patterns.creational.abstract_factory;

public class VisaFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
			case GOLD: {
				return new VisaGoldCreditCard();
			}

			default: {
				return new VisaBlackCreditCard();
			}
		}
	}

	@Override
	public Validator getValidator(CardType cardType) {
		return new VisaValidator();
	}
}
