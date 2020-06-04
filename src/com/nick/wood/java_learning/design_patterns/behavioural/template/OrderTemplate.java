package com.nick.wood.java_learning.design_patterns.behavioural.template;

public abstract class OrderTemplate {
	public boolean isGift;
	public abstract void doCheckout();
	public abstract void doPayment();
	public abstract void doReceipt();
	public abstract void doDelivery();

	// final means cant be overwritten by subclasses
	public final void wrapGift() {
		System.out.println("Wrap gift");
	}

	public final void process() {

		doCheckout();
		doPayment();
		if (isGift) {
			wrapGift();
		} else {
			doReceipt();
		}
		doDelivery();

	}

}
