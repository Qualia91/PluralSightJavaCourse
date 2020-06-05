package com.nick.wood.java_learning.monads.result_monad;

import javax.lang.model.type.ErrorType;
import java.util.function.Function;

public interface Result<T> {

	boolean isSuccess();

	T getResult();

	ErrorType getError();

	String getOptionalErrorMessage();

	default <R> Result<R> map(Function<? super T, ? extends R> mapper) {
		return isSuccess() ?
				Success.of(mapper.apply(getResult())) : (Failure<R>) this;
	}
	default <R> Result<R> flatMap(Function<? super T, Result<R>> mapper) {
		return isSuccess() ?
				mapper.apply(getResult()) : (Failure<R>) this;
	}
	default <R> R fold(Function<? super T, ? extends R> successFunction, Function<Failure<R>, ? extends R> failureFunction) {
		return isSuccess() ?
				successFunction.apply(getResult()) : failureFunction.apply((Failure<R>) this);
	}


}
