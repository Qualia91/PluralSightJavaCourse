package com.nick.wood.java_learning.design_patterns.structural.proxy;

/**
 *
 */
public class TwitterServiceStub implements TwitterService {
	@Override
	public String getTimeline(String screenName) {
		return "Hello, World!";
	}

	@Override
	public void postTimeline(String screenName, String message) {
		System.out.println("Timeline posted");
	}
}
