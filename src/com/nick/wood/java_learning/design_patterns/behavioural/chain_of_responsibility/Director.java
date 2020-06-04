package com.nick.wood.java_learning.design_patterns.behavioural.chain_of_responsibility;

public class Director extends Handler {
	@Override
	public void handleRequest(Request request) {
		if (request.getRequestType().equals(RequestType.CONFERENCE)) {
			System.out.println("Directors can approve conferences");
		} else {
			successor.handleRequest(request);
		}
	}
}
