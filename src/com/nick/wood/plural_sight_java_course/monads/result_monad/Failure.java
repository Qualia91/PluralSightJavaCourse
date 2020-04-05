package com.nick.wood.plural_sight_java_course.monads.result_monad;

import javax.lang.model.type.ErrorType;
import java.util.NoSuchElementException;

public class Failure<T> implements Result<T> {

	private final ErrorType errorType;

	private final String optionalErrorMessage;

	public Failure(ErrorType errorType, String optionalErrorMessage) {
		this.errorType = errorType;
		this.optionalErrorMessage = optionalErrorMessage;
	}

	@Override
	public boolean isSuccess() {
		return false;
	}

	@Override
	public T getResult() {
		throw new NoSuchElementException("There is no result in Failure");
	}

	@Override
	public ErrorType getError() {
		return errorType;
	}

	@Override
	public String getOptionalErrorMessage() {
		return optionalErrorMessage;
	}
}
