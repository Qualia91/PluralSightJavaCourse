package com.nick.wood.plural_sight_java_course.monads.result_monad;

import javax.lang.model.type.ErrorType;
import java.util.NoSuchElementException;

public class Success<T> implements Result<T> {

	private final T result;

	public Success(T result) {
		this.result = result;
	}

	public static <T> Result<T> of(T result) {
		return new Success<>(result);
	}

	@Override
	public boolean isSuccess() {
		return true;
	}

	@Override
	public T getResult() {
		return result;
	}

	@Override
	public ErrorType getError() {
		throw new NoSuchElementException("There is no error in success");
	}

	@Override
	public String getOptionalErrorMessage() {
		throw new NoSuchElementException("There is no optional error in success");
	}
}
