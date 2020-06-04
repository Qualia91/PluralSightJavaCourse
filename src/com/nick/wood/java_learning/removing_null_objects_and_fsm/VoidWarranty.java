package com.nick.wood.java_learning.removing_null_objects_and_fsm;

import java.time.LocalDate;

// null object used for no warranty available
public class VoidWarranty implements Warranty {
	@Override
	public Warranty on(LocalDate date) {
		return this;
	}

	// this needs a claim method that doesnt run runnable so the unvoid warranties arent printed out
	@Override
	public void claim(Runnable action) {

	}
}
