package com.nick.wood.java_learning.reflection_api.meta_model;

import java.lang.reflect.Field;

public class ColumnField {

	private Field field;

	public ColumnField(Field field) {
		this.field = field;
	}

	public String getName() {
		return field.getName();
	}

	public Class<?> getType() {
		return field.getType();
	}

}
