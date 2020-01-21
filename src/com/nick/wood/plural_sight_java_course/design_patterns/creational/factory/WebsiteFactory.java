package com.nick.wood.plural_sight_java_course.design_patterns.creational.factory;

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
