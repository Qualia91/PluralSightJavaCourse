package com.nick.wood.java_learning.design_patterns.behavioural.chain_of_responsibility;

public class CEO extends Handler {
	@Override
	public void handleRequest(Request request) {
		System.out.println("CEO's can do what they want");
	}
}
