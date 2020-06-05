package com.nick.wood.java_learning.design_patterns.behavioural.template;

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
