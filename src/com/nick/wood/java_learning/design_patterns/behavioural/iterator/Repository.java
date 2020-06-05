package com.nick.wood.java_learning.design_patterns.behavioural.iterator;

import java.util.Iterator;

public class Repository implements Iterable<String> {

	private String[] items;
	private int index;

	public Repository() {
		items = new String[30];
		index = 0;
	}

	public void add(String a) {
		if (index >= items.length) {
			String[] largerArray = new String[items.length * 2];
			System.arraycopy(items, 0, largerArray, 0, items.length);
			items = largerArray;
			// below causes gc to reclaim memory
			largerArray = null;
		}
		items[index] = a;
		index++;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < items.length && items[currentIndex] != null;
			}

			@Override
			public String next() {
				return items[currentIndex++];
			}

		};
	}

}
