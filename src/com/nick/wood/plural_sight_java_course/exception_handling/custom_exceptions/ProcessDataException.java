package com.nick.wood.plural_sight_java_course.exception_handling.custom_exceptions;

public class ProcessDataException extends Exception {

	private int customData;

	public ProcessDataException() {
	}

	public ProcessDataException(Exception e) {
		super(e);
	}

	public ProcessDataException(String message) {
		super(message);
	}

	public ProcessDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProcessDataException(Throwable cause) {
		super(cause);
	}

	public ProcessDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public int getCustomData() {
		return customData;
	}

	public void setCustomData(int customData) {
		this.customData = customData;
	}
}
