package com.nick.wood.java_learning.design_patterns.creational.factory;

public class WebsiteFactory {

	public static Website getWebsite(FactoryTypes factoryTypes) {
		switch (factoryTypes) {
			case BLOG: {
				return new Blog();
			}
			case SHOP: {
				return new Shop();
			}
			default: {
				return new NONE();
			}
		}
	}
}
