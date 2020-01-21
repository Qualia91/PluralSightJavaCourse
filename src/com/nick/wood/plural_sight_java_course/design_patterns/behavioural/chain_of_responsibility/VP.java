package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.chain_of_responsibility;

public class VP extends Handler {
	@Override
	public void handleRequest(Request request) {
		if (request.getRequestType().equals(RequestType.PURCHASE)) {
			if (request.getAmount() < 1500) {
				System.out.println("VP's can approve purchases below 1500");
			} else {
				successor.handleRequest(request);
			}
		}
	}
}
