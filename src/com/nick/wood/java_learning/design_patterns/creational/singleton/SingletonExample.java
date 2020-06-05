package com.nick.wood.java_learning.design_patterns.creational.singleton;

// lazily loaded and thread safe
public class SingletonExample {

	// volatile makes it remain a singleton even with changes through the jvm
	// the keyword ensures the variable is read from the main memory and not
	// from cpu cache, helping thread safety
	// also guarantees visibility of changes to variable across threads
	private static volatile SingletonExample singletonExample = null;

	// to also ensure thread safety you need to protect against reflection library calling of constructor
	// after it has already been made (ensuring only one object). do this by ensuring that the singleton
	// instance is always null when this constructor is called
	private SingletonExample() {
		if (singletonExample != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	// putting creation here makes it lazily loaded
	public static SingletonExample getInstance() {
		if (singletonExample == null) {
			// could make whole class synchronised to ensure thread safety but you would get a massive performance hit.
			// instead if the instance is null (being created for first time) synchronise it and recheck.
			// this stops 2 threads creating it at the same time.
			synchronized (SingletonExample.class) {
				if (singletonExample == null) {
					singletonExample = new SingletonExample();
				}
			}
		}
		return singletonExample;
	}

}
