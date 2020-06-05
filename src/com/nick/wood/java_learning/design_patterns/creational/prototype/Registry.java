package com.nick.wood.java_learning.design_patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

	private Map<String, Item> items = new HashMap<>();

	public Registry() {
		loadItems();
	}

	public <T extends Item> T createItem (String type) {
		T item = null;

		try {
			item = (T) items.get(type).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return item;
	}

	private void loadItems() {
		Movie movie = new Movie();
		movie.setTitle("Basic");
		movie.setPrice(24.99);
		movie.setRuntime("2 hours");
		items.putIfAbsent("Movie", movie);

		Book book = new Book();
		book.setNumberOfPages(335);
		book.setPrice(19.99);
		book.setTitle("Basic Book");
		items.putIfAbsent("Book", book);
	}
}
