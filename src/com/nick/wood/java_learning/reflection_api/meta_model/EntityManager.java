package com.nick.wood.java_learning.reflection_api.meta_model;

/**
 * models writing and reading of T to database
 *
 * @param <T>
 */
public interface EntityManager<T> {

	void persist(T t);

	T read(Class<?> clzz, long primaryKey);

}
