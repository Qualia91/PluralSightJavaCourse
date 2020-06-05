package com.nick.wood.java_learning.design_patterns.structural.composite;

public class MenuItem extends MenuComponent {

	public MenuItem(String name, String url) {
		super(name, url);
	}

	@Override
	public String toString() {
		return print(this);
	}
}
