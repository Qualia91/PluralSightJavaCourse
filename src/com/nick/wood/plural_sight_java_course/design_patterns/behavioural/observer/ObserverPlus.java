package com.nick.wood.plural_sight_java_course.design_patterns.behavioural.observer;

// differs from javas observable by having an instance of the
// subject of the observation
public abstract class ObserverPlus {

	protected Subject subject;

	abstract public void update();

}
