package com.nick.wood.java_learning.design_patterns.behavioural.chain_of_responsibility;

public class Request {

	private final RequestType requestType;
	private final double amount;

	public Request(RequestType requestType, double amount) {
		this.requestType = requestType;
		this.amount = amount;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public double getAmount() {
		return amount;
	}
}
