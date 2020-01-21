package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<ObserverPlus> observerPluses = new ArrayList<>();

	abstract void setState(String state);
	abstract String getState();

	public void attach(ObserverPlus observerPlus) {
		observerPluses.add(observerPlus);
	}

	public void detach(ObserverPlus observerPlus) {
		observerPluses.remove(observerPlus);
	}

	public void notifyObservers() {
		for (ObserverPlus observerPlus : observerPluses) {
			observerPlus.update();
		}
	}
}
