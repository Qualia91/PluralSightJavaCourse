package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.template;

public class WebOrder extends OrderTemplate {
	@Override
	public void doCheckout() {
		System.out.println("Do checkout in web");
	}

	@Override
	public void doPayment() {
		System.out.println("Do payment in web");
	}

	@Override
	public void doReceipt() {
		System.out.println("Do receipt in web");
	}

	@Override
	public void doDelivery() {
		System.out.println("Do delivery in web");
	}

}
