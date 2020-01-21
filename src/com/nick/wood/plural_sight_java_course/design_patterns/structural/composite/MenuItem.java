package com.nick.wood.plural_sight_java_course.design_patterns.structural.composite;

public class MenuItem extends MenuComponent {

	public MenuItem(String name, String url) {
		super(name, url);
	}

	@Override
	public String toString() {
		return print(this);
	}
}
