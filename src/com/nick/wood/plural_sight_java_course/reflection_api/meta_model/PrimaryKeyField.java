package com.nick.wood.plural_sight_java_course.reflection_api.meta_model;

import java.lang.reflect.Field;

public class PrimaryKeyField {

	private final Field field;

	public PrimaryKeyField(Field field) {
		this.field = field;
	}

	public String getName() {
		return field.getName();
	}

	public Class<?> getType() {
		return field.getType();
	}

}
