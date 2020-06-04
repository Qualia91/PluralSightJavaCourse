package com.nick.wood.java_learning.design_patterns.behavioural.state;

public class Fan {

	State fanOff;
	State fanLow;
	State fanMed;
	State fanHigh;

	State state;

	public Fan() {
		fanOff = new FanOffState(this);
		fanLow = new FanLowState(this);
		fanMed = new FanMedState(this);
		fanHigh = new FanHighState(this);
		state = fanOff;
	}

	public void pullChain() {
		state.handleRequest();
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getFanOff() {
		return fanOff;
	}

	public State getFanLow() {
		return fanLow;
	}

	public State getFanMed() {
		return fanMed;
	}

	public State getFanHigh() {
		return fanHigh;
	}

	public State getState() {
		return state;
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
