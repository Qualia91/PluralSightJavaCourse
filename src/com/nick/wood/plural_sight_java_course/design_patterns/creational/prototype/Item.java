package com.nick.wood.plural_sight_java_course.design_patterns.creational.prototype;

// look into this, cloneable is suspect
public abstract class Item implements Cloneable<Item> {
	private String title;
	private double price;
	private String url;

	@Override
	public Item clone() throws CloneNotSupportedException {
		return (Item) super.clone();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
