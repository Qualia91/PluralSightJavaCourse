package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.template;

public class StoreOrder extends OrderTemplate {
	@Override
	public void doCheckout() {
		System.out.println("Do checkout in store");
	}

	@Override
	public void doPayment() {
		System.out.println("Do payment in store");
	}

	@Override
	public void doReceipt() {
		System.out.println("Do receipt in store");
	}

	@Override
	public void doDelivery() {
		System.out.println("Do delivery in store");
	}
}
