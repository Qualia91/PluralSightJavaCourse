package com.nick.wood.plural_sight_java_course.removing_null_objects_and_fsm;

import java.time.LocalDate;

// warranty interface containing a few special case objects to get rid of nulls
public interface Warranty {

	Warranty on(LocalDate date);

	// this has a default so that this doesn't need to be implemented in every class
	// as it will always look the same
	default void claim(Runnable action) { action.run(); }

	// Default object for 'null' object
	// by default it is static and final
	Warranty VOID = new VoidWarranty();

	// can provide a different constructor here
	static Warranty lifetime(LocalDate issuedOn) {
		return new LifetimeWarranty(issuedOn);
	}
}
