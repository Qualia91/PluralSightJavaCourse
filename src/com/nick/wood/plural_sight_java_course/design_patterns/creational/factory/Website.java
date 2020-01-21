package com.nick.wood.plural_sight_java_course.design_patterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

	protected List<Page> pages = new ArrayList<>();

	public Website() {
		this.createWebsite();
	}

	public List<Page> getPages() {
		return pages;
	}

	public abstract void createWebsite();

}