package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.chain_of_responsibility;

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
