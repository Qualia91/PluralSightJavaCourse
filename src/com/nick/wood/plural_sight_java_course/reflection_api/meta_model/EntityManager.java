package com.nick.wood.plural_sight_java_course.reflection_api.meta_model;

/**
 * models writing and reading of T to database
 *
 * @param <T>
 */
public interface EntityManager<T> {

	void persist(T t);

	T read(Class<?> clzz, long primaryKey);

}
