package com.nick.wood.plural_sight_java_course.design_patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

	private Map<String, ConcreteFlyweight> stringConcreteFlyweightMap = new HashMap<>();

	// factory method
	public ConcreteFlyweight lookup(String name) {
		stringConcreteFlyweightMap.putIfAbsent(name, new ConcreteFlyweight(name));
		return stringConcreteFlyweightMap.get(name);
	}

	public int getMapSize() {
		return stringConcreteFlyweightMap.size();
	}

}
