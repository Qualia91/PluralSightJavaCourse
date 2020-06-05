package com.nick.wood.java_learning.design_patterns.structural.composite;

import com.nick.wood.java_learning.design_patterns.structural.bridge.movie_printer_example.StringBuilderPlus;

public class Menu extends MenuComponent {

	public Menu(String name, String url) {
		super(name, url);
	}

	@Override
	public String toString() {

		StringBuilderPlus sbp = new StringBuilderPlus();

		sbp.appendLine(print(this));

		for (MenuComponent menuComponent : menuComponentList) {

			sbp.appendLine(menuComponent.toString());

		}

		return sbp.toString();
	}

	public MenuComponent add(MenuComponent menuComponent) {

		super.menuComponentList.add(menuComponent);

		return menuComponent;

	}

	public MenuComponent remove(MenuComponent menuComponent) {

		super.menuComponentList.remove(menuComponent);

		return menuComponent;

	}
}
