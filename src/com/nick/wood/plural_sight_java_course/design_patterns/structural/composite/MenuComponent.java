package com.nick.wood.plural_sight_java_course.design_patterns.structural.composite;

import com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.movie_printer_example.StringBuilderPlus;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

	String name;
	String url;
	List<MenuComponent> menuComponentList = new ArrayList<>();

	public MenuComponent(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public abstract String toString();

	public String print(MenuComponent menuComponent) {
		StringBuilderPlus sbp = new StringBuilderPlus();
		sbp.append(name).append(": ").append(url);
		return sbp.toString();
	}
}
