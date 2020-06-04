package com.nick.wood.java_learning.design_patterns.behavioural.chain_of_responsibility;

public abstract class Handler {

	protected Handler successor;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	public abstract void handleRequest(Request request);
}
