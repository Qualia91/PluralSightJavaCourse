package com.nick.wood.plural_sight_java_course.reflection_api.meta_model;

import com.nick.wood.plural_sight_java_course.reflection_api.annotations.Column;
import com.nick.wood.plural_sight_java_course.reflection_api.annotations.PrimaryKey;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetaModel<T> {

	private final Class<T> clss;

	public MetaModel(Class<T> clss) {
		this.clss = clss;
	}

	public static <T> MetaModel<T> of(Class<T> clss) {
		return new MetaModel<T>(clss);
	}

	public PrimaryKeyField getPrimaryKey() {

		for (Field declaredField : clss.getDeclaredFields()) {

			PrimaryKey primaryKey = declaredField.getAnnotation(PrimaryKey.class);

			if (primaryKey != null) {

				return new PrimaryKeyField(declaredField);

			}

		}

		throw new IllegalArgumentException("No primary field found in class " + clss.getSimpleName());

	}

	public List<ColumnField> getColumns() {

		ArrayList<ColumnField> columnFields = new ArrayList<>();

		for (Field declaredField : clss.getDeclaredFields()) {

			Column column = declaredField.getAnnotation(Column.class);

			if (column != null) {

				columnFields.add(new ColumnField(declaredField));

			}

		}

		return columnFields;

	}
}
