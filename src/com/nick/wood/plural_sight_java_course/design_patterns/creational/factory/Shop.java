package com.nick.wood.plural_sight_java_course.design_patterns.creational.factory;

public class Shop extends Website {
	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ItemPage());
		pages.add(new SearchPage());
	}
}
